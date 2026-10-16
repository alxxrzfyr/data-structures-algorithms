/*
    ==== REVERSE AN ARRAY ====

    Use two indexes, one at each end. Swap their values and move both indexes inward until the
    array is reversed.

    Complexity: Time O(n), extra space O(1).
    Try: Print the array before and after the swaps.
*/

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        int[] values = {1, 2, 3, 4, 5};

        for (int left = 0, right = values.length - 1; left < right; left++, right--) {      // <---- Swap the end values, then move both indexes toward the middle.
            int temp = values[left];

            values[left] = values[right];
            values[right] = temp;
        }

        System.out.println(Arrays.toString(values));
    }
}
