/*
    ==== RADIX SORT ====

    Sort nonnegative integers by one digit at a time, starting with the ones digit. Each pass must
    keep the previous order of items with equal current digits.

    Complexity: Time O(d(n + b)), space O(n + b), for d digits and base b; stable: equal-key items
    keep their original order.
    Try: Use base 10 and print the array after each digit pass.
*/

import java.util.Arrays;

public class RadixSort {
    static void sort(int[] a) {
        for (int v : a) {
            if (v < 0) {
                throw new IllegalArgumentException("values must be nonnegative");
            }
        }

        int max = Arrays.stream(a).max().orElse(0);

        for (long place = 1; max / place > 0; place *= 10) {    // <---- Process ones, then tens, then hundreds, using a stable counting pass.
            int[] count = new int[10], out = new int[a.length];

            for (int v : a) {
                count[(int) ((v / place) % 10)]++;
            }

            for (int i = 1; i < 10; i++) {
                count[i] += count[i - 1];
            }

            for (int i = a.length - 1; i >= 0; i--) {           // <---- Read backward to keep equal-digit items in their previous order.
                int digit = (int) ((a[i] / place) % 10);

                out[--count[digit]] = a[i];
            }

            System.arraycopy(out, 0, a, 0, a.length);
        }
    }

    public static void main(String[] args) {
        int[] a = {170, 45, 75, 90, 802, 24, 2, 66};

        sort(a);

        System.out.println(Arrays.toString(a));
    }
}
