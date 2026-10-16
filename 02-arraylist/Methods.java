/*
    ==== USEFUL LIST METHODS ====

    List is an interface: it describes operations a list supports. ArrayList implements those
    operations using an internal array.

    Complexity: contains and indexOf are O(n); get is O(1) for ArrayList.
    Try: Compare set with add: which operation changes the list size?
*/

import java.util.ArrayList;
import java.util.List;

public class Methods {
    public static void main(String[] args) {
        List<Integer> scores = new ArrayList<>(List.of(7, 4, 9));

        scores.set(1, 8);                               // <---- set replaces the value at this index; it does not add another item.

        System.out.println("contains 9: " + scores.contains(9));
        System.out.println(scores);
    }
}
