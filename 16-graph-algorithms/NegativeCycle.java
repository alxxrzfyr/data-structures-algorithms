/*
    ==== BELLMAN-FORD NEGATIVE-CYCLE DETECTION ====

    After V - 1 relaxation passes, a further improvement means a reachable negative cycle
    exists. Such a cycle can reduce route cost without limit. This example only reports cycles
    reachable from the chosen source; an unreachable negative cycle does not affect that source.

    Complexity: Time O(VE), extra space O(V). Use valid vertex indexes and int edge weights;
    small graphs keep long sums within range.
    Try: Add an unreachable negative cycle and explain why the source-specific result stays
    false.
*/

import java.util.Arrays;

public class NegativeCycle {
    static boolean reachable(int vertices, int[][] edges, int source) {
        long[] distance = new long[vertices];

        Arrays.fill(distance, Long.MAX_VALUE);
        distance[source] = 0;

        for (int pass = 0; pass < vertices; pass++) {
            boolean changed = false;

            for (int[] edge : edges) {
                if (distance[edge[0]] != Long.MAX_VALUE && distance[edge[0]] + edge[2] < distance[edge[1]]) {
                    distance[edge[1]] = distance[edge[0]] + edge[2];
                    changed = true;

                    if (pass == vertices - 1) {
                        return true;                   // <---- An improvement on the extra pass cannot come from a finite simple shortest path.
                    }
                }
            }

            if (!changed) {
                return false;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] edges = {{0, 1, 1}, {1, 2, -2}, {2, 1, 1}};

        System.out.println(reachable(3, edges, 0));
    }
}
