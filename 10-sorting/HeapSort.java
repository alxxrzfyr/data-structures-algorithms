/*
    ==== HEAP SORT ====

    A max heap keeps its largest item at the root. Move that item to the array's end, shrink the
    heap, and restore the heap property.

    Complexity: Best/average/worst O(n log n); extra space O(1); unstable: equal-key items may
    change order.
    Try: Print the array after heap construction to see that a heap is not fully sorted.
*/

import java.util.Arrays;

public class HeapSort {
    static void down(int[] a, int size, int i) {
        while (true) {
            int largest = i, l = 2 * i + 1, r = l + 1;

            if (l < size && a[l] > a[largest]) {
                largest = l;
            }

            if (r < size && a[r] > a[largest]) {
                largest = r;
            }

            if (largest == i) {
                return;
            }

            int t = a[i];

            a[i] = a[largest];
            a[largest] = t;
            i = largest;
        }
    }

    static void sort(int[] a) {
        for (int i = a.length / 2 - 1; i >= 0; i--) {       // <---- Start at the last parent; its children are already valid heaps.
            down(a, a.length, i);
        }

        for (int end = a.length - 1; end > 0; end--) {      // <---- Put the maximum at the end, then repair the remaining heap.
            int t = a[0];

            a[0] = a[end];
            a[end] = t;
            down(a, end, 0);
        }
    }

    public static void main(String[] args) {
        int[] a = {8, 3, 6, 2, 7, 1};

        sort(a);

        System.out.println(Arrays.toString(a));
    }
}
