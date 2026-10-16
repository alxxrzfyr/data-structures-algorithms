/*
    ==== TRAVERSE AN ARRAYLIST ====

    Use an enhanced for loop to read every list item. Use an index loop when you also need each
    item's position.

    Complexity: Time O(n), extra space O(1); n is the number of list items.
    Try: Remove an item in an index loop and check whether the shifted next item gets skipped.
*/

import java.util.ArrayList;

public class Traversal {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();

        names.add("Ada");
        names.add("Grace");

        for (String name : names) {                     // <---- The loop gives you each name without needing an index variable.
            System.out.println(name);
        }
    }
}
