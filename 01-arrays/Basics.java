/*
    ==== ARRAY BASICS ====

    An array stores a fixed number of values. An index is an item's position, starting at 0 and
    ending at length - 1.

    Complexity: Read or write by index: O(1).
    Try: Access numbers[numbers.length] and explain why Java reports an invalid index.
*/

public class Basics {
    public static void main(String[] args) {
        int[] numbers = {4, 2, 7, 1};

        numbers[1] = 9;                                 // <---- Index 1 means the second item because array indexes start at 0.

        System.out.println("length=" + numbers.length + ", item=" + numbers[1]);
    }
}
