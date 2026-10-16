/*
    ==== BREADTH-FIRST SEARCH ====

    Breadth-first search, or BFS, uses a queue to visit graph nodes in layers. For unweighted
    edges, these layers give shortest distances measured in steps.

    Complexity: Time O(V + E), space O(V). V = vertices (nodes); E = edges (connections).
    Try: Start from another vertex and explain which vertices remain unreachable.
*/

import java.util.*;

public class BreadthFirstSearch {
    public static void main(String[] args) {
        List<List<Integer>> g = List.of(List.of(1, 2), List.of(0, 3), List.of(0), List.of(1));
        boolean[] seen = new boolean[g.size()];
        Queue<Integer> q = new ArrayDeque<>();

        q.offer(0);
        seen[0] = true;

        while (!q.isEmpty()) {
            int v = q.poll();

            System.out.print(v + " ");

            for (int n : g.get(v)) {
                if (!seen[n]) {
                    seen[n] = true;                     // <---- Mark before enqueueing so another edge cannot queue this node again.
                    q.offer(n);
                }
            }
        }
    }
}
