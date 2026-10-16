/*
    ==== MINIMUM SPANNING FORESTS ====

    A disconnected undirected graph cannot have one spanning tree. Start Prim at each unvisited
    vertex to build one minimum spanning tree per component. Together they form a minimum
    spanning forest. Represent every edge in both directions; negative weights are allowed.

    Complexity: Lazy priority-queue time O(V + E log(E + 1)), extra space O(V + E). Isolated
    vertices form zero-edge trees.
    Try: Count the accepted edges and verify that the total is V minus the number of components.
*/

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class SpanningForest {
    record Edge(int to, int weight) {}

    static long weight(List<List<Edge>> graph) {
        boolean[] seen = new boolean[graph.size()];
        PriorityQueue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(Edge::weight));
        long total = 0;

        for (int start = 0; start < graph.size(); start++) {
            if (seen[start]) {
                continue;
            }

            queue.offer(new Edge(start, 0));           // <---- Begin a new component only after the previous component's queue empties.

            while (!queue.isEmpty()) {
                Edge edge = queue.poll();

                if (seen[edge.to()]) {
                    continue;
                }

                seen[edge.to()] = true;
                total += edge.weight();

                for (Edge next : graph.get(edge.to())) {
                    if (!seen[next.to()]) {
                        queue.offer(next);
                    }
                }
            }
        }

        return total;
    }

    public static void main(String[] args) {
        List<List<Edge>> graph = List.of(List.of(new Edge(1, 4)), List.of(new Edge(0, 4)), List.of());

        System.out.println(weight(graph));
    }
}
