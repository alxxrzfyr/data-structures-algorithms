/*
    ==== SET INTERSECTION ====

    The intersection of two sets contains values found in both. Copy one set, then remove values
    that are missing from the other.

    Complexity: Expected time O(n + m) for set sizes n and m; extra space O(n) for the copy of
    first.
    Try: Try repeated input values. Explain why a set intersection returns each value only once.
*/

import java.util.HashSet;
import java.util.Set;

public class Intersections {
    public static void main(String[] args) {
        Set<Integer> first = Set.of(1, 2, 3, 4), second = Set.of(3, 4, 5);
        Set<Integer> common = new HashSet<>(first);

        common.retainAll(second);                       // <---- retainAll removes values that are not also in second.

        System.out.println(common);
    }
}
