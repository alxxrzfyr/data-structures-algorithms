/*
    ==== CONNECTED COMPONENTS ====

    A connected component is a group of vertices linked by paths. Start a search at each unvisited
    vertex to count the separate groups.

    Complexity: Time O(V + E), extra space O(V). V = vertices (nodes); E = edges (connections).
    Try: Add one isolated vertex and count it as its own component.
*/

import java.util.*;

public class ConnectedComponents {
    public static void main(String[] args) {
        List<List<Integer>> g = List.of(List.of(1), List.of(0), List.of(3), List.of(2), List.of());
        boolean[] seen = new boolean[g.size()];
        int count = 0;

        for (int start = 0; start < g.size(); start++) {
            if (!seen[start]) {
                count++;                                // <---- This vertex was not in any group searched earlier, so start a new one.

                Deque<Integer> s = new ArrayDeque<>();

                s.push(start);
                seen[start] = true;

                while (!s.isEmpty()) {
                    int v = s.pop();

                    for (int n : g.get(v)) {
                        if (!seen[n]) {
                            seen[n] = true;
                            s.push(n);
                        }
                    }
                }
            }
        }

        System.out.println(count);
    }
}
