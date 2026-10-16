/*
    ==== QUICK SORT ====

    Choose a pivot value and partition the array around it. Values at or below the pivot move
    left; larger values stay right. Recurse on the smaller part and continue the larger part
    in a loop. Only the smaller part adds a call-stack frame, keeping recursive depth logarithmic.

    Complexity: Best/average time O(n log n), worst O(n²). Extra stack space O(log n) because
    only the smaller partition recurses. The average bound assumes a suitable input model. Unstable.
    Try: Use already sorted input and trace why choosing the last item makes uneven partitions.
*/

import java.util.Arrays;

public class QuickSort {
    static void sort(int[] a, int low, int high) {
        while (low < high) {
            int pivot = a[high], store = low;

            for (int i = low; i < high; i++) {
                if (a[i] <= pivot) {
                    int t = a[i];

                    a[i] = a[store];
                    a[store++] = t;
                }
            }

            int t = a[store];

            a[store] = a[high];
            a[high] = t;

            if (store - low < high - store) {
                sort(a, low, store - 1);
                low = store + 1;
            } else {
                sort(a, store + 1, high);
                high = store - 1;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {8, 3, 6, 2, 7, 1};

        sort(a, 0, a.length - 1);

        System.out.println(Arrays.toString(a));
    }
}
