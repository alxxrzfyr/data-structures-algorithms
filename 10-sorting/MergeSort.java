/*
    ==== MERGE SORT ====

    Split the array into smaller ranges until each has at most one item. Merge sorted ranges by
    repeatedly taking the smaller front value.

    Complexity: Best/average/worst O(n log n); extra space O(n); stable: equal-key items keep
    their original order.
    Try: Draw the merge step for [2, 5] and [1, 4].
*/

import java.util.Arrays;

public class MergeSort {
    static void sort(int[] a, int left, int right) {
        if (right - left < 2) {                         // <---- Zero or one item is already sorted; this is the base case.
            return;
        }

        int mid = (left + right) / 2;

        sort(a, left, mid);                             // <---- Each half must be sorted before we merge them.
        sort(a, mid, right);

        int[] merged = new int[right - left];
        int i = left, j = mid, k = 0;

        while (i < mid && j < right) {                  // <---- Take the smaller front value; on a tie, keep the left one first.
            merged[k++] = a[i] <= a[j] ? a[i++] : a[j++];
        }

        while (i < mid) {                               // <---- One half is empty, so copy the items left in the other half.
            merged[k++] = a[i++];
        }

        while (j < right) {
            merged[k++] = a[j++];
        }

        System.arraycopy(merged, 0, a, left, merged.length);
    }

    public static void main(String[] args) {
        int[] a = {8, 3, 6, 2, 7, 1};

        sort(a, 0, a.length);

        System.out.println(Arrays.toString(a));
    }
}
