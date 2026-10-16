/*
    ==== COUNTING SORT ====

    For integers in a small range, count how often each value appears. Then write the values back
    in increasing order.

    Complexity: Time O(n + k), space O(n + k) including output, for key range k.
    Try: Handle negative values by shifting the count index by the minimum.
*/

import java.util.Arrays;

public class CountingSort {
    static int[] sort(int[] a, int max) {
        if (max < 0 || max == Integer.MAX_VALUE) {
            throw new IllegalArgumentException("invalid maximum");
        }

        for (int v : a) {
            if (v < 0 || v > max) {
                throw new IllegalArgumentException("value outside counting range");
            }
        }

        int[] count = new int[max + 1];

        for (int v : a) {                               // <---- count[v] stores how many times value v appears.
            count[v]++;
        }

        int[] out = new int[a.length];
        int at = 0;

        for (int v = 0; v < count.length; v++) {        // <---- Write each value as many times as its count says.
            while (count[v]-- > 0) {
                out[at++] = v;
            }
        }

        return out;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(new int[] {3, 1, 2, 3, 0, 2}, 3)));
    }
}
