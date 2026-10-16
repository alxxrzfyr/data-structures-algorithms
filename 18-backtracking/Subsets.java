/*
    ==== GENERATE SUBSETS ====

    A subset selects some of the input items, possibly none. For each item, recursively explore
    two choices: leave it out or include it.

    Complexity: Time O(n·2ⁿ) including copying output; recursion depth O(n).
    Try: Add an empty input and confirm it produces the empty subset.
*/

import java.util.*;

public class Subsets {
    static void build(int[] a, int i, List<Integer> path) {
        if (i == a.length) {
            System.out.println(path);
            return;
        }

        build(a, i + 1, path);                          // <---- Explore the choice that leaves this item out.
        path.add(a[i]);                                 // <---- Include this item, search that choice, then remove it to backtrack.
        build(a, i + 1, path);
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        build(new int[] {1, 2, 3}, 0, new ArrayList<>());
    }
}
