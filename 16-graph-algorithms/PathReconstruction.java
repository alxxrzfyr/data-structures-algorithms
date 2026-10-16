/*
    ==== RECONSTRUCTING A SHORTEST PATH ====

    A shortest distance does not identify the route. During BFS, store the parent that first
    discovers each vertex. Follow parents backward from the target, then reverse that chain. An
    unreachable target has no path.

    Complexity: Time O(V + E), extra space O(V). Vertex indexes must be valid; an empty graph
    has no valid source.
    Try: Store parents during Dijkstra relaxation and reconstruct a weighted shortest path.
*/

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.Arrays;

public class PathReconstruction {
    static List<Integer> path(List<List<Integer>> graph, int source, int target) {
        int[] parent = new int[graph.size()];
        Queue<Integer> queue = new ArrayDeque<>();

        Arrays.fill(parent, -1);
        parent[source] = source;
        queue.offer(source);

        while (!queue.isEmpty()) {
            int vertex = queue.poll();

            for (int next : graph.get(vertex)) {
                if (parent[next] < 0) {
                    parent[next] = vertex;             // <---- The first discovery records a predecessor on a shortest unweighted path.
                    queue.offer(next);
                }
            }
        }

        List<Integer> route = new ArrayList<>();

        if (parent[target] < 0) {
            return route;
        }

        for (int vertex = target; vertex != source; vertex = parent[vertex]) {
            route.add(vertex);
        }

        route.add(source);
        Collections.reverse(route);

        return route;
    }

    public static void main(String[] args) {
        List<List<Integer>> graph = List.of(List.of(1, 2), List.of(3), List.of(3), List.of(), List.of());

        System.out.println(path(graph, 0, 3));
        System.out.println(path(graph, 0, 4));
    }
}
