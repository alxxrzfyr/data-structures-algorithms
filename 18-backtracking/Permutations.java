/*
    ==== GENERATE PERMUTATIONS ====

    A permutation is an ordering of all the items. Choose an unused item, recurse to fill the next
    position, then undo the choice and try another item.

    Complexity: Time O(n·n!) when printing each permutation; recursion space O(n).
    Try: Use duplicate input values and find which generated permutations repeat.
*/

import java.util.*;

public class Permutations {
    static void permute(int[] a, boolean[] used, List<Integer> path) {
        if (path.size() == a.length) {
            System.out.println(path);
            return;
        }

        for (int i = 0; i < a.length; i++) {
            if (!used[i]) {
                used[i] = true;                         // <---- Mark this item as used so it cannot appear twice in one permutation.
                path.add(a[i]);
                permute(a, used, path);
                path.remove(path.size() - 1);
                used[i] = false;                        // <---- Backtrack: this item is available again after leaving the current path.
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3};

        permute(a, new boolean[a.length], new ArrayList<>());
    }
}
