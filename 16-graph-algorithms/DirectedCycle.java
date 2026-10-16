/*
    ==== CYCLES IN A DIRECTED GRAPH ====

    Directed DFS distinguishes unvisited, active, and finished vertices. An edge to an active
    ancestor creates a cycle. An edge to a finished vertex does not by itself imply one. Start
    DFS at every unvisited vertex so disconnected components are checked too.

    Complexity: Time O(V + E), extra space O(V) including the recursion stack. Uses valid
    adjacency lists.
    Try: Compare edges 0->1, 0->2, 1->2 with the cyclic edges 0->1, 1->2, 2->0.
*/

import java.util.List;

public class DirectedCycle {
    static boolean visit(List<List<Integer>> graph, int vertex, int[] state) {
        state[vertex] = 1;                             // <---- Mark this vertex active while its recursive call is unfinished.

        for (int next : graph.get(vertex)) {
            if (state[next] == 1) {
                return true;                           // <---- This edge returns to a vertex still on the current DFS path.
            }

            if (state[next] == 0 && visit(graph, next, state)) {
                return true;
            }
        }

        state[vertex] = 2;                             // <---- All outgoing paths are checked, so this vertex is finished.

        return false;
    }

    static boolean hasCycle(List<List<Integer>> graph) {
        int[] state = new int[graph.size()];

        for (int vertex = 0; vertex < graph.size(); vertex++) {
            if (state[vertex] == 0 && visit(graph, vertex, state)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(hasCycle(List.of(List.of(1, 2), List.of(2), List.of())));
        System.out.println(hasCycle(List.of(List.of(1), List.of(2), List.of(0))));
    }
}
