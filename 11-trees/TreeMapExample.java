/*
    ==== ORDERED MAPS WITH TREEMAP ====

    TreeMap stores key-value pairs in a red-black tree. Keys stay sorted by their natural order
    or a Comparator. floorKey finds the greatest key at most a target; higherKey finds the next
    larger key. This supplies ordered operations that HashMap does not promise.

    Complexity: For these integer keys, get/put/remove and neighbor queries take O(log n);
    storage O(n).
    Try: Check floorKey below the smallest key and higherKey above the largest key.
*/

import java.util.TreeMap;

public class TreeMapExample {
    public static void main(String[] args) {
        TreeMap<Integer, String> names = new TreeMap<>();

        names.put(20, "Mina");
        names.put(10, "Leo");
        names.put(30, "Ada");

        System.out.println(names.keySet());
        System.out.println(names.floorKey(25));        // <---- The predecessor-or-equal query returns 20.
        System.out.println(names.higherKey(20));
        System.out.println(names.subMap(10, true, 30, false));
    }
}
