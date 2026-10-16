/*
    ==== WHY A LOOP IS CORRECT ====

    A loop invariant is a fact that stays true before and after each iteration. To prove this
    maximum search, show that best is the largest value in the processed prefix: it starts true,
    stays true, and covers the whole array when the loop ends.

    Complexity: Time O(n), extra space O(1). Input must contain at least one value.
    Try: Write the invariant for a loop that counts occurrences of a target.
*/

public class LoopInvariant {
    static int maximum(int[] values) {
        if (values.length == 0) {
            throw new IllegalArgumentException("empty array");
        }

        int best = values[0];                          // <---- A one-element prefix has that element as its maximum.

        for (int i = 1; i < values.length; i++) {
            best = Math.max(best, values[i]);          // <---- Include the next value while keeping best correct for the processed prefix.
        }

        return best;
    }

    public static void main(String[] args) {
        System.out.println(maximum(new int[] {4, 9, 2, 7}));
    }
}
