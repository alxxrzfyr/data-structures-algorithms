/*
    ==== ORDERED UNIQUENESS WITH TREESET ====

    TreeSet keeps values sorted and treats a comparison result of zero as a duplicate. Make
    ordering consistent with equals when following the Set contract. With these integer values,
    both equality and comparison agree.

    Complexity: Integer add/remove/contains and neighbor queries take O(log n); storage O(n).
    Try: Use a string comparator based only on length and explain why different words can count
    as duplicates.
*/

import java.util.TreeSet;

public class TreeSetExample {
    public static void main(String[] args) {
        TreeSet<Integer> values = new TreeSet<>();

        values.add(8);
        values.add(3);
        values.add(8);
        values.add(12);

        System.out.println(values);
        System.out.println(values.lower(8));           // <---- Find the greatest stored value strictly below 8.
        System.out.println(values.ceiling(9));
    }
}
