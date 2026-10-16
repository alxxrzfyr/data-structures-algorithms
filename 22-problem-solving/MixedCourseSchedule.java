/*
    ==== PRACTICE COURSE PREREQUISITES ====

    Problem: return a valid course order, or an empty array if prerequisites contain a cycle.
    Each pair [a, b] means a must be completed before b. Model the constraints as directed edges
    and use indegrees. Example: [0, 2], [1, 2], [2, 3] permits [0, 1, 2, 3]. Several valid
    orders may exist.

    Complexity: Time O(V + E), extra space O(V + E) including the graph. Course IDs must be
    between 0 and V - 1.
    Try: Explain how duplicate prerequisite pairs should be handled consistently in both
    indegrees and adjacency lists.
*/

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class MixedCourseSchedule {
    static int[] order(int courses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[courses], result = new int[courses];

        for (int i = 0; i < courses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] pair : prerequisites) {
            graph.get(pair[0]).add(pair[1]);
            indegree[pair[1]]++;
        }

        Queue<Integer> ready = new ArrayDeque<>();

        for (int i = 0; i < courses; i++) {
            if (indegree[i] == 0) {
                ready.offer(i);
            }
        }

        int completed = 0;

        while (!ready.isEmpty()) {
            int course = ready.poll();

            result[completed++] = course;

            for (int next : graph.get(course)) {
                if (--indegree[next] == 0) {
                    ready.offer(next);
                }
            }
        }

        return completed == courses ? result : new int[0];   // <---- Unprocessed courses mean a directed cycle prevents completion.
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(order(4, new int[][] {{0, 2}, {1, 2}, {2, 3}})));
    }
}
