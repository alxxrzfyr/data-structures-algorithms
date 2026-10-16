/*
    ==== COUNTING WORK ====

    Big O describes how the number of steps grows as input gets larger. Count repeated operations
    instead of timing the program.

    Complexity: One pass: O(n). All pairs: O(n²). n is the array length; extra space is O(1).
    Try: Add more array items and compare the one-pass and all-pairs check counts.
*/

public class Complexity {
    public static void main(String[] args) {
        int[] numbers = {2, 4, 6, 8};
        int checks = 0;

        for (int number : numbers) {                    // <---- One loop visits n items, so its work grows in a straight line: O(n).
            checks++;
        }

        System.out.println("One pass: " + checks);

        checks = 0;

        for (int left : numbers) {                      // <---- Two loops each visit n items, giving n times n checks: O(n²).
            for (int right : numbers) {
                checks++;
            }
        }

        System.out.println("All pairs: " + checks);
    }
}
