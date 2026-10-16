/*
    ==== ADJACENCY LIST ====

    An adjacency list stores each vertex's neighbors. A vertex is a graph node, and an edge
    connects two vertices. An undirected edge needs entries in both neighbor lists.

    Complexity: Storage O(V + E). Reading neighbors takes O(degree), the number of neighbors; V
    counts vertices, E counts edges.
    Try: Represent an isolated vertex and check that it still has a list.
*/

import java.util.ArrayList;
import java.util.List;

public class AdjacencyList {
    public static void main(String[] args) {
        int vertices = 4;
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(1);
        graph.get(1).add(0);                            // <---- Add the reverse connection too because this edge works both ways.
        graph.get(1).add(2);
        graph.get(2).add(1);

        System.out.println(graph);
    }
}
