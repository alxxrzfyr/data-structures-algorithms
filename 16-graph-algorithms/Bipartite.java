/*
    ==== TWO-COLORING AN UNDIRECTED GRAPH ====

    A graph is bipartite if every edge joins opposite groups. BFS assigns alternating colors. If
    an edge joins equal colors, no valid two-coloring exists. Check every component, including
    isolated vertices. The input must represent each undirected edge in both directions.

    Complexity: Time O(V + E), extra space O(V). An empty graph is bipartite.
    Try: Explain why a triangle fails while a four-vertex cycle succeeds.
*/

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class Bipartite {
    static boolean check(List<List<Integer>> graph) {
        int[] color = new int[graph.size()];
        Queue<Integer> queue = new ArrayDeque<>();

        Arrays.fill(color, -1);

        for (int start = 0; start < graph.size(); start++) {
            if (color[start] >= 0) {
                continue;
            }

            color[start] = 0;
            queue.offer(start);

            while (!queue.isEmpty()) {
                int vertex = queue.poll();

                for (int next : graph.get(vertex)) {
                    if (color[next] < 0) {
                        color[next] = 1 - color[vertex];   // <---- Every newly discovered neighbor must be in the opposite group.
                        queue.offer(next);
                    } else if (color[next] == color[vertex]) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(check(List.of(List.of(1), List.of(0), List.of())));
        System.out.println(check(List.of(List.of(1, 2), List.of(0, 2), List.of(0, 1))));
    }
}
