/*
    ==== TWO SUM WITH TWO POINTERS ====

    For a sorted array, start one pointer at each end. If their sum is too small, move left
    inward; if too large, move right inward.

    Complexity: Sorting O(n log n); scan O(n); extra space depends on whether original indexes
    must be kept.
    Try: Compare with brute force. If input is unsorted, sort a copy before using these pointer
    rules.
*/

public class TwoPointers {
    public static void main(String[] args) {
        int[] a = {1, 3, 4, 6, 8};
        int target = 10, l = 0, r = a.length - 1;

        while (l < r) {                                 // <---- Use sorted order to discard pairs that cannot reach the target.
            int sum = a[l] + a[r];

            if (sum == target) {
                System.out.println(a[l] + " + " + a[r]);

                break;
            }

            if (sum < target) {
                l++;
            } else {
                r--;
            }
        }
    }
}
