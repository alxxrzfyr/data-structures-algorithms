/*
    ==== TOPOLOGICAL SORT WITH KAHN’S ALGORITHM ====

    A topological order puts each prerequisite before the work that depends on it. Kahn's
    algorithm tracks indegree, the number of incoming edges, and starts with vertices whose
    indegree is 0.

    Complexity: Time O(V + E), extra space O(V). If fewer than V nodes are produced, a cycle
    exists. V = vertices (nodes); E = edges (connections).
    Try: Add an edge that creates a cycle and check the output count.
*/

import java.util.*;

public class TopologicalSort {
    public static void main(String[] args) {
        int n = 4;
        int[][] edges = {{0, 2}, {1, 2}, {2, 3}};
        List<List<Integer>> g = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }

        int[] in = new int[n];

        for (int[] e : edges) {
            g.get(e[0]).add(e[1]);
            in[e[1]]++;
        }

        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (in[i] == 0) {                           // <---- Zero incoming edges means this vertex has no unfinished prerequisites.
                q.offer(i);
            }
        }

        int done = 0;

        while (!q.isEmpty()) {
            int v = q.poll();

            System.out.print(v + " ");

            done++;

            for (int x : g.get(v)) {
                if (--in[x] == 0) {                     // <---- One prerequisite is done; queue this vertex if none remain.
                    q.offer(x);
                }
            }
        }

        System.out.println(" acyclic=" + (done == n));
    }
}
