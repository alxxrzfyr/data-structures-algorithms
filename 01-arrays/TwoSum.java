/*
    ==== TWO SUM IN A SORTED ARRAY ====

    Find two different indexes whose values add to the target. A sorted array lets two pointers
    rule out many pairs without checking each one.

    Complexity: Time O(n), extra space O(1).
    Try: Print positions starting from 1 instead of indexes starting from 0.
*/

public class TwoSum {
    public static void main(String[] args) {
        int[] a = {1, 2, 4, 7, 11};
        int target = 9, l = 0, r = a.length - 1;

        while (l < r) {                                 // <---- Keep the indexes different while moving toward the target sum.
            int s = a[l] + a[r];

            if (s == target) {
                System.out.println(l + ", " + r);

                break;
            }

            if (s < target) {
                l++;
            } else {
                r--;
            }
        }
    }
}
