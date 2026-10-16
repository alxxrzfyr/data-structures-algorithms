/*
    ==== RECURSIVE ARRAY SUM ====

    Add the current array value to the sum of the remaining values. The index moves forward until
    it reaches the array's length.

    Complexity: Time O(n), call-stack space O(n).
    Try: Start at index 1 and explain why the first value is no longer part of the sum.
*/

public class RecursiveArraySum {
    static int sum(int[] values, int index) {
        if (index == values.length) {                       // <---- There are no items left, so the remaining sum is 0.
            return 0;
        }

        return values[index] + sum(values, index + 1);      // <---- Add this item to the result of the next recursive call.
    }

    public static void main(String[] args) {
        System.out.println(sum(new int[] {2, 4, 6}, 0));
    }
}
