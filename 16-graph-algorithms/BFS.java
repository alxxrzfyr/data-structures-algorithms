/*
    ==== BFS SHORTEST DISTANCE ====

    BFS visits an unweighted graph one distance layer at a time. The first visit to a vertex gives
    its shortest distance in number of edges.

    Complexity: Time O(V + E), space O(V). V = vertices (nodes); E = edges (connections).
    Try: Add a second shortest path and observe that the distance remains the same.
*/

import java.util.*;

public class BFS {
    public static void main(String[] args) {
        List<List<Integer>> g = List.of(List.of(1, 2), List.of(0, 3), List.of(0, 3), List.of(1, 2));
        int[] d = new int[g.size()];

        Arrays.fill(d, -1);

        Queue<Integer> q = new ArrayDeque<>();

        q.add(0);
        d[0] = 0;

        while (!q.isEmpty()) {
            int v = q.remove();

            for (int n : g.get(v)) {
                if (d[n] < 0) {
                    d[n] = d[v] + 1;                    // <---- This is the first visit, so one step from v gives the shortest distance.
                    q.add(n);
                }
            }
        }

        System.out.println(Arrays.toString(d));
    }
}
