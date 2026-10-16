/*
    ==== LOWER BOUND ====

    In sorted input, lower bound finds the first index whose value is greater than or equal to the
    target. If none exists, it returns the array length.

    Complexity: Time O(log n), extra space O(1).
    Try: Test a target that appears more than once.
*/

public class LowerBound {
    static int lowerBound(int[] a, int target) {
        int left = 0, right = a.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (a[mid] < target) {                      // <---- Skip values below target, but keep equal ones to find the first match.
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        System.out.println(lowerBound(new int[] {1, 3, 3, 3, 8}, 3));
    }
}
