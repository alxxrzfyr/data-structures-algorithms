/*
    ==== CYCLE DETECTION IN AN UNDIRECTED GRAPH ====

    A cycle is a path that returns to an earlier vertex. In an undirected DFS, a visited neighbor
    forms a cycle only when it is not the parent you came from.

    Complexity: Time O(V + E), extra space O(V). V = vertices (nodes); E = edges (connections).
    Try: Add an isolated vertex and confirm it does not create a cycle.
*/

import java.util.*;

public class CycleDetection {
    static boolean cycle(List<List<Integer>> g, int v, int parent, boolean[] seen) {
        seen[v] = true;

        for (int n : g.get(v)) {
            if (!seen[n]) {
                if (cycle(g, n, v, seen)) {
                    return true;
                }
            } else if (n != parent) {
                return true;                            // <---- This neighbor is already visited and is not our parent, so a cycle exists.
            }
        }

        return false;
    }

    public static void main(String[] args) {
        List<List<Integer>> g = List.of(List.of(1, 2), List.of(0, 2), List.of(0, 1));

        System.out.println(cycle(g, 0, -1, new boolean[g.size()]));
    }
}
