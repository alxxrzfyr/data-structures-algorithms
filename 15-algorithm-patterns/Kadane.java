/*
    ==== MAXIMUM SUBARRAY WITH KADANE ====

    A subarray is a consecutive range. For each position, either extend the best range ending
    just before it or start a new range here. A negative previous sum can only make a future
    range worse. Track the best ending-here sum and the best overall sum separately.

    Complexity: Time O(n), extra space O(1), compared with O(n squared) range enumeration using
    running sums. Input must be nonempty; the chosen subarray is nonempty.
    Try: Return the best range's start and end indexes, including an all-negative input.
*/

public class Kadane {
    static long maximum(int[] values) {
        if (values.length == 0) {
            throw new IllegalArgumentException("empty array");
        }

        long ending = values[0], best = values[0];

        for (int i = 1; i < values.length; i++) {
            ending = Math.max(values[i], ending + values[i]);   // <---- Decide whether the best range ending here starts fresh or extends.
            best = Math.max(best, ending);
        }

        return best;
    }

    public static void main(String[] args) {
        System.out.println(maximum(new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(maximum(new int[] {-5, -2, -8}));
    }
}
