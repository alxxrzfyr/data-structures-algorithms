/*
    ==== CONTAINS DUPLICATE ====

    A set remembers values already seen. Checking it once per item finds a duplicate without
    comparing every possible pair.

    Complexity: Expected time O(n), extra space O(n).
    Try: Try an empty array, a one-item array, and an array with two equal values.
*/

import java.util.HashSet;
import java.util.Set;

public class EasyContainsDuplicate {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 1};
        Set<Integer> s = new HashSet<>();
        boolean duplicate = false;

        for (int v : a) {
            if (!s.add(v)) {                            // <---- add returned false because this value was already in the set.
                duplicate = true;
                break;
            }
        }

        System.out.println(duplicate);
    }
}
