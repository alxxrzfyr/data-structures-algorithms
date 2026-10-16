/*
    ==== DELETE FROM AN ARRAY ====

    An array cannot shrink. To delete an item, copy the other items into a smaller array and shift
    the later items left.

    Complexity: Time O(n), extra space O(n) for this simple returned-array version.
    Try: Delete the only item from a one-item array. The result should be an empty array.
*/

import java.util.Arrays;

public class Deletion {
    static int[] deleteAt(int[] values, int index) {
        if (index < 0 || index >= values.length) {
            throw new IndexOutOfBoundsException();
        }

        int[] result = new int[values.length - 1];

        for (int i = 0; i < index; i++) {
            result[i] = values[i];
        }

        for (int i = index + 1; i < values.length; i++) {       // <---- Skip the deleted index and copy later items one position to the left.
            result[i - 1] = values[i];
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(deleteAt(new int[] {10, 20, 30}, 1)));
    }
}
