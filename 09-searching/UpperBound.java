/*
    ==== UPPER BOUND ====

    In sorted input, upper bound finds the first index whose value is strictly greater than the
    target. If none exists, it returns the array length.

    Complexity: Time O(log n), extra space O(1).
    Try: Subtract lower bound from upper bound to count matching values.
*/

public class UpperBound {
    static int upperBound(int[] a, int target) {
        int left = 0, right = a.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (a[mid] <= target) {                     // <---- Skip values equal to target too; we need the first larger value.
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        System.out.println(upperBound(new int[] {1, 3, 3, 3, 8}, 3));
    }
}
