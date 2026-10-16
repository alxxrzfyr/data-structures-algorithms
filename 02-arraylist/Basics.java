/*
    ==== ARRAYLIST BASICS ====

    An ArrayList stores items in an internal array. When that array is full, ArrayList creates a
    larger one and copies the items into it.

    Complexity: get O(1); append amortized O(1), meaning constant on average over many adds;
    middle insertion O(n).
    Try: Remove the first item and explain why later indexes change.
*/

import java.util.ArrayList;

public class Basics {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();

        names.add("Ada");
        names.add("Linus");
        names.add("Grace");
        names.remove(1);                                // <---- Removing the second item shifts later items left and reduces size.

        System.out.println(names);
    }
}
