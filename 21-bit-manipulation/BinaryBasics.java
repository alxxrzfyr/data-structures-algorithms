/*
    ==== READ BINARY DIGITS ====

    Binary writes numbers with 0 and 1. Each bit position represents a power of two: 1, 2, 4, 8,
    and so on.

    Complexity: Converting or scanning w bits takes O(w).
    Try: Compare decimal 13 with its binary digits and sum the corresponding powers of two.
*/

public class BinaryBasics {
    public static void main(String[] args) {
        int value = 13;

        System.out.println(Integer.toBinaryString(value));

        for (int bit = 3; bit >= 0; bit--) {            // <---- Move the chosen bit to position 0, then use AND 1 to read only that bit.
            System.out.print((value >> bit) & 1);
        }
    }
}
