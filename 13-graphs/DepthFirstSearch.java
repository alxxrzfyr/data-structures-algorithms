/*
    ==== DEPTH-FIRST SEARCH ====

    Depth-first search, or DFS, follows one path before returning to try other branches. Track
    visited nodes so graph cycles cannot cause endless recursive calls.

    Complexity: Time O(V + E), space O(V) for visited state and recursion/stack. V = vertices
    (nodes); E = edges (connections).
    Try: Use an explicit stack to avoid recursive call depth on a large graph.
*/

import java.util.*;

public class DepthFirstSearch {
    static void dfs(List<List<Integer>> g, int v, boolean[] seen) {
        seen[v] = true;                                 // <---- Mark this node before exploring its neighbors to prevent repeated visits.

        System.out.print(v + " ");

        for (int n : g.get(v)) {
            if (!seen[n]) {
                dfs(g, n, seen);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> g = List.of(List.of(1, 2), List.of(0, 3), List.of(0), List.of(1));

        dfs(g, 0, new boolean[g.size()]);
    }
}
