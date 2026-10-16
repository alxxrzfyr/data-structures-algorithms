/*
    ==== BUBBLE SORT ====

    Compare neighboring values and swap them if they are out of order. Each pass moves a largest
    remaining value to the end.

    Complexity: Best O(n) with the early-stop flag; average/worst O(n²); space O(1); stable:
    equal-key items keep their original order.
    Try: Remove the early-stop flag and count comparisons.
*/

import java.util.Arrays;

public class BubbleSort {
    static void sort(int[] a) {
        for (int end = a.length - 1; end > 0; end--) {      // <---- The largest item in this unsorted range moves to its final index.
            boolean changed = false;

            for (int i = 0; i < end; i++) {
                if (a[i] > a[i + 1]) {
                    int t = a[i];

                    a[i] = a[i + 1];
                    a[i + 1] = t;
                    changed = true;
                }
            }

            if (!changed) {                                 // <---- No swaps happened, so another pass would not change anything.
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {5, 1, 4, 2};

        sort(a);

        System.out.println(Arrays.toString(a));
    }
}
