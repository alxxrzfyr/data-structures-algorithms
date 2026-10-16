/*
    ==== DFS REACHABILITY ====

    DFS can check reachability: whether a path connects one vertex to another. Follow edges
    recursively and remember visited vertices.

    Complexity: Time O(V + E), space O(V). V = vertices (nodes); E = edges (connections).
    Try: Run it on a directed graph and respect edge direction.
*/

import java.util.*;

public class DFS {
    static boolean reaches(List<List<Integer>> g, int from, int target, boolean[] seen) {
        if (from == target) {
            return true;
        }

        seen[from] = true;                              // <---- Remember this node so another path does not make us search it again.

        for (int n : g.get(from)) {
            if (!seen[n] && reaches(g, n, target, seen)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        List<List<Integer>> g = List.of(List.of(1), List.of(2), List.of(), List.of());

        System.out.println(reaches(g, 0, 2, new boolean[g.size()]));
    }
}
