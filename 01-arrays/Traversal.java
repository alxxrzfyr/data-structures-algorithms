/*
    ==== ARRAY TRAVERSAL ====

    Traversal means visiting the items in a collection. An enhanced for loop reads each array
    value without needing its index.

    Complexity: Time O(n), extra space O(1).
    Try: Print the indexes as well as the values.
*/

public class Traversal {
    public static void main(String[] args) {
        int[] numbers = {4, 2, 7, 1};

        for (int number : numbers) {                    // <---- This enhanced for loop reads each value in its stored order.
            System.out.println(number);
        }
    }
}
