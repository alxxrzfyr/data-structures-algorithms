/*
    ==== SELECTION SORT ====

    Find the smallest value in the unsorted part. Swap it into the next position, then repeat for
    the remaining items.

    Complexity: Best/average/worst O(n²); space O(1); unstable: equal-key items may change order.
    Try: Count swaps and compare with bubble sort on already-sorted input.
*/

import java.util.Arrays;

public class SelectionSort {
    static void sort(int[] a) {
        for (int start = 0; start < a.length; start++) {
            int min = start;                            // <---- Search the unsorted part for its smallest value.

            for (int i = start + 1; i < a.length; i++) {
                if (a[i] < a[min]) {
                    min = i;
                }
            }

            int t = a[start];                           // <---- Move that smallest value to the start of the unsorted part.

            a[start] = a[min];
            a[min] = t;
        }
    }

    public static void main(String[] args) {
        int[] a = {5, 1, 4, 2};

        sort(a);

        System.out.println(Arrays.toString(a));
    }
}
