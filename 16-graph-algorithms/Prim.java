/*
    ==== PRIM MINIMUM SPANNING TREE ====

    Prim builds a minimum spanning tree for a connected, undirected graph. Start at one vertex and
    repeatedly add the cheapest edge that reaches a new vertex.

    Complexity: With a priority queue, O((V + E) log V); space O(V + E). V = vertices (nodes); E =
    edges (connections).
    Try: Start from another vertex and check whether the graph is connected.
*/

import java.util.*;

public class Prim {
    record Edge(int to, int weight) {}

    public static void main(String[] args) {
        List<List<Edge>> g =
                List.of(
                        List.of(new Edge(1, 4), new Edge(2, 1)),
                        List.of(new Edge(0, 4), new Edge(2, 2), new Edge(3, 5)),
                        List.of(new Edge(0, 1), new Edge(1, 2), new Edge(3, 3)),
                        List.of(new Edge(1, 5), new Edge(2, 3)));
        boolean[] seen = new boolean[g.size()];
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        q.add(new int[] {0, 0});

        long total = 0;

        while (!q.isEmpty()) {
            int[] x = q.poll();
            int v = x[0];

            if (seen[v]) {                              // <---- This vertex is already in the tree, so do not add its cost again.
                continue;
            }

            seen[v] = true;
            total += x[1];                              // <---- Add the cheapest queued connection to a vertex outside the tree.

            for (Edge e : g.get(v)) {
                if (!seen[e.to()]) {
                    q.add(new int[] {e.to(), e.weight()});
                }
            }
        }

        System.out.println("weight=" + total);
    }
}
