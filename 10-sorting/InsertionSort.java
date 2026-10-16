/*
    ==== INSERTION SORT ====

    Keep the start of the array sorted. Save the next value and shift larger values right until
    there is room to insert it.

    Complexity: Best O(n); average/worst O(n²); space O(1); stable: equal-key items keep their
    original order.
    Try: Trace how many shifts sorted input and reverse-sorted input require.
*/

import java.util.Arrays;

public class InsertionSort {
    static void sort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int value = a[i], j = i - 1;                // <---- Save this value before shifting other items into its old position.

            while (j >= 0 && a[j] > value) {
                a[j + 1] = a[j];
                j--;
            }

            a[j + 1] = value;                           // <---- The larger items have moved, so this is the saved value's position.
        }
    }

    public static void main(String[] args) {
        int[] a = {5, 1, 4, 2};

        sort(a);

        System.out.println(Arrays.toString(a));
    }
}
