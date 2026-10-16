/*
    ==== INSERT INTO AN ARRAY ====

    An array cannot grow. Create a larger array, put the new value at its index, and move later
    values one position right.

    Complexity: Time O(n), extra space O(n).
    Try: Insert at the start and at the end, then trace the result indexes.
*/

import java.util.Arrays;

public class Insertion {
    static int[] insert(int[] values, int index, int value) {
        int[] result = new int[values.length + 1];

        for (int i = 0; i < index; i++) {               // <---- Copy the earlier values into the same indexes in the new array.
            result[i] = values[i];
        }

        result[index] = value;                          // <---- Put the new value here; the next loop moves later items right.

        for (int i = index; i < values.length; i++) {
            result[i + 1] = values[i];
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(insert(new int[] {10, 30, 40}, 1, 20)));
    }
}
