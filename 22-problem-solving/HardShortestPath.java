/*
    ==== PRACTICE SHORTEST ROUTE WITH ONE DISCOUNT ====

    Problem: find the cheapest directed route when at most one edge can cost half its weight,
    rounded down. A vertex alone is not a complete state: remember whether the discount was
    used. Example: edges 0->1 cost 8, 1->2 cost 8, and 0->2 cost 20 give answer 10. All weights
    must be nonnegative ints; return -1 for an unreachable target.

    Complexity: Lazy-heap time O(V + E log(E + 1)), extra space O(V + E). There are two states
    per vertex; route sums use long. Vertex indexes must be valid.
    Try: Store a parent for each state and recover both the route and the discounted edge.
*/

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class HardShortestPath {
    record Edge(int to, int weight) {}
    record State(int vertex, int used, long cost) {}

    static long cheapest(List<List<Edge>> graph, int source, int target) {
        long[][] distance = new long[graph.size()][2];
        PriorityQueue<State> queue = new PriorityQueue<>(Comparator.comparingLong(State::cost));

        for (int vertex = 0; vertex < graph.size(); vertex++) {
            Arrays.fill(distance[vertex], Long.MAX_VALUE);

            for (Edge edge : graph.get(vertex)) {
                if (edge.weight() < 0) {
                    throw new IllegalArgumentException("nonnegative weights required");
                }
            }
        }

        distance[source][0] = 0;
        queue.offer(new State(source, 0, 0));

        while (!queue.isEmpty()) {
            State current = queue.poll();

            if (current.cost() != distance[current.vertex()][current.used()]) {
                continue;
            }

            for (Edge edge : graph.get(current.vertex())) {
                relax(distance, queue, edge.to(), current.used(), current.cost() + edge.weight());

                if (current.used() == 0) {
                    relax(distance, queue, edge.to(), 1, current.cost() + edge.weight() / 2);   // <---- Spending the discount moves into the used-discount state.
                }
            }
        }

        long best = Math.min(distance[target][0], distance[target][1]);

        return best == Long.MAX_VALUE ? -1 : best;
    }

    static void relax(long[][] distance, PriorityQueue<State> queue, int vertex, int used, long cost) {
        if (cost < distance[vertex][used]) {
            distance[vertex][used] = cost;
            queue.offer(new State(vertex, used, cost));
        }
    }

    public static void main(String[] args) {
        List<List<Edge>> graph = List.of(
                List.of(new Edge(1, 8), new Edge(2, 20)),
                List.of(new Edge(2, 8)),
                List.of());

        System.out.println(cheapest(graph, 0, 2));
    }
}
