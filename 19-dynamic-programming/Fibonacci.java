/*
    ==== FIBONACCI WITH TWO VARIABLES ====

    Fibonacci's recurrence, its rule for the next value, adds the previous two values. Keep just
    those two values instead of a full table.

    Complexity: Time O(n), extra space O(1); n is the Fibonacci index.
    Try: Print the values at each loop step to connect them to the recurrence.
*/

public class Fibonacci {
    public static void main(String[] args) {
        int n = 10, previous = 0, current = 1;

        for (int i = 0; i < n; i++) {
            int next = previous + current;              // <---- Add the two previous numbers, then move the variables forward.

            previous = current;
            current = next;
        }

        System.out.println(previous);
    }
}
