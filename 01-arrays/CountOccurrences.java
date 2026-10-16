/*
    ==== COUNT OCCURRENCES ====

    An occurrence is one appearance of a value. Scan the array and count how many values match the
    target.

    Complexity: Time O(n), extra space O(1).
    Try: Use a target that is absent and explain why the count stays zero.
*/

public class CountOccurrences {
    public static void main(String[] args) {
        int[] a = {2, 5, 2, 2, 8};
        int target = 2, count = 0;

        for (int v : a) {                               // <---- Increase the count only when the current value equals the target.
            if (v == target) {
                count++;
            }
        }

        System.out.println(count);
    }
}
