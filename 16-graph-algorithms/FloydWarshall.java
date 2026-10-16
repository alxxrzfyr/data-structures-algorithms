/*
    ==== FLOYD-WARSHALL ====

    Floyd-Warshall finds shortest distances between all pairs of vertices. It tries each vertex as
    a possible stop between the two endpoints.

    Complexity: Time O(V³), space O(V²). V = vertices (nodes); E = edges (connections).
    Try: Pick vertices i and j, then trace how allowing each intermediate vertex changes d[i][j].
*/

import java.util.Arrays;

public class FloydWarshall {
    public static void main(String[] args) {
        int inf = 999;                                  // <---- 999 means no direct edge here; valid distances in this example are smaller.
        int[][] d = {{0, 3, inf}, {inf, 0, 2}, {4, inf, 0}};

        for (int k = 0; k < d.length; k++) {            // <---- Check whether passing through k gives a shorter route from i to j.
            for (int i = 0; i < d.length; i++) {
                for (int j = 0; j < d.length; j++) {
                    if (d[i][k] != inf && d[k][j] != inf) {
                        d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
                    }
                }
            }
        }

        for (int[] row : d) {
            System.out.println(Arrays.toString(row));
        }
    }
}
