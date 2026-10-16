/*
    ==== LONGEST POSITIVE WINDOW UNDER A LIMIT ====

    A sliding window is a section between left and right indexes. For positive values and a
    nonnegative limit, expand right and shrink left whenever the sum is too large.

    Complexity: Time O(n), extra space O(1). Negative values break this shrink rule.
    Try: Try a negative input value and explain why shrinking left may no longer reduce the sum.
*/

public class SlidingWindow {
    public static void main(String[] args) {
        int[] a = {2, 1, 3, 2, 1};
        int limit = 5, left = 0, sum = 0, best = 0;

        for (int right = 0; right < a.length; right++) {
            sum += a[right];

            while (sum > limit) {                       // <---- Removing positive values from the left reduces the sum until it fits.
                sum -= a[left++];
            }

            best = Math.max(best, right - left + 1);
        }

        System.out.println(best);
    }
}
