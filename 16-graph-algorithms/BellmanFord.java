/*
    ==== BELLMAN-FORD ====

    Bellman-Ford repeatedly relaxes edges: it updates a saved distance when an edge offers a
    shorter route. V - 1 passes are enough if there is no reachable negative cycle.

    Complexity: Time O(VE), space O(V). V = vertices (nodes); E = edges (connections).
    Try: Add one extra pass. A further distance improvement signals a reachable negative cycle.
*/

import java.util.Arrays;

public class BellmanFord {
    public static void main(String[] args) {
        int n = 4;
        int[][] e = {{0, 1, 4}, {0, 2, 5}, {1, 2, -2}, {2, 3, 3}};
        long[] d = new long[n];

        Arrays.fill(d, Long.MAX_VALUE);
        d[0] = 0;

        for (int pass = 1; pass < n; pass++) {          // <---- A shortest path without cycles has at most V - 1 edges.
            boolean changed = false;

            for (int[] x : e) {
                if (d[x[0]] != Long.MAX_VALUE && d[x[0]] + x[2] < d[x[1]]) {
                    d[x[1]] = d[x[0]] + x[2];
                    changed = true;
                }
            }

            if (!changed) {                             // <---- No distance changed, so more passes would give the same answers.
                break;
            }
        }

        System.out.println(Arrays.toString(d));
    }
}
