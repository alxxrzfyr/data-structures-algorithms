/*
    ==== WHY DOUBLING MAKES APPEND CHEAP ====

    A resize copies all existing values. Doubling capacity makes the copied counts form 1 + 2 +
    4 + ... . Before n appends finish, their sum is less than 2n. Total append work is linear
    even though one resizing append can be expensive.

    Complexity: n appends take O(n) total time, or amortized O(1) each; storage O(n). The factor
    two is this example's policy, not a Java API guarantee.
    Try: Count copies when capacity grows by only one slot each time.
*/

import java.util.Arrays;

public class AmortizedAnalysis {
    public static void main(String[] args) {
        int[] data = new int[1];
        int size = 0, copies = 0;

        for (int value = 0; value < 10; value++) {
            if (size == data.length) {
                copies += size;
                data = Arrays.copyOf(data, data.length * 2);   // <---- Extra spare slots delay the next copying operation.
            }

            data[size++] = value;
        }

        System.out.println("items=" + size + ", copied=" + copies);
    }
}
