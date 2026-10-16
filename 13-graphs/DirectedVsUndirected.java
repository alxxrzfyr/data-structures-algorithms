/*
    ==== DIRECTED AND UNDIRECTED EDGES ====

    A directed edge works only from its source to its destination. An undirected edge works both
    ways, so an adjacency list stores it in both directions.

    Complexity: Adding to a neighbor list is amortized O(1), or constant on average over many
    additions.
    Try: Use one directed edge and check which vertices can reach each other.
*/

import java.util.ArrayList;
import java.util.List;

public class DirectedVsUndirected {
    public static void main(String[] args) {
        List<List<Integer>> g = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            g.add(new ArrayList<>());
        }

        g.get(0).add(1);                                // <---- This adds 0 to 1 only; it does not automatically add 1 to 0.

        System.out.println("from 0: " + g.get(0));
        System.out.println("from 1: " + g.get(1));
    }
}
