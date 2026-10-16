/*
    ==== BUILD A HEAP IN LINEAR TIME ====

    Heapify turns an array into a heap. Start at the last parent and sift down: swap a parent with
    a larger child until the max-heap rule holds.
    Most nodes are near the leaves and move only a little: about n/4 nodes move one level, n/8
    move two, and so on. The weighted sum stays proportional to n.

    Complexity: Build time O(n); extra space O(1). Adding n items one at a time can take O(n log
    n).
    Try: Count sift-down steps for a complete tree of increasing sizes.
*/

import java.util.Arrays;

public class Heapify {
    static void down(int[] a, int size, int i) {
        while (2 * i + 1 < size) {
            int c = 2 * i + 1;

            if (c + 1 < size && a[c + 1] > a[c]) {
                c++;
            }

            if (a[i] >= a[c]) {
                break;
            }

            int t = a[i];

            a[i] = a[c];
            a[c] = t;
            i = c;
        }
    }

    public static void main(String[] args) {
        int[] a = {3, 9, 2, 1, 4, 5};

        for (int i = a.length / 2 - 1; i >= 0; i--) {       // <---- Leaves need no work; fix parents from the bottom toward the root.
            down(a, a.length, i);
        }

        System.out.println(Arrays.toString(a));
    }
}
