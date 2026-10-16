/*
    ==== DIJKSTRA SHORTEST PATHS ====

    Dijkstra uses a priority queue to explore the smallest known distance next. It requires
    nonnegative edge weights, meaning zero or positive costs, so an explored shortest distance
    cannot improve later.

    Complexity: With a priority queue, O((V + E) log V); distance array O(V). V = vertices
    (nodes); E = edges (connections).
    Try: Add an unreachable vertex and leave its distance as infinity.
*/

import java.util.*;

public class Dijkstra {
    record Edge(int to, int weight) {}

    public static void main(String[] args) {
        List<List<Edge>> g =
                List.of(
                        List.of(new Edge(1, 4), new Edge(2, 1)),
                        List.of(new Edge(3, 1)),
                        List.of(new Edge(1, 2), new Edge(3, 5)),
                        List.of());
        long[] d = new long[g.size()];

        Arrays.fill(d, Long.MAX_VALUE);
        d[0] = 0;

        PriorityQueue<long[]> q = new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));

        q.offer(new long[] {0, 0});

        while (!q.isEmpty()) {
            long[] cur = q.poll();
            int v = (int) cur[0];
            long cost = cur[1];

            if (cost != d[v]) {                         // <---- This queue entry is outdated because a shorter distance was saved later.
                continue;
            }

            for (Edge e : g.get(v)) {
                if (cost + e.weight() < d[e.to()]) {    // <---- Relax this edge: save the new distance only if it is shorter.
                    d[e.to()] = cost + e.weight();
                    q.offer(new long[] {e.to(), d[e.to()]});
                }
            }
        }

        System.out.println(Arrays.toString(d));
    }
}
