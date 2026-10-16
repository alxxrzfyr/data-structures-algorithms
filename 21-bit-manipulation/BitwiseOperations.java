/*
    ==== TEST AND SET A BIT ====

    A mask selects a bit position. AND tests that bit, OR sets it to 1, and XOR toggles it between
    0 and 1.

    Complexity: Each bit operation is O(1) for a primitive integer.
    Try: Write a clear-bit expression and verify that other bits stay unchanged.
*/

public class BitwiseOperations {
    public static void main(String[] args) {
        int value = 0;
        int bit = 3;

        value |= 1 << bit;                              // <---- 1 << bit builds the mask; OR sets that bit to 1.

        System.out.println((value & (1 << bit)) != 0);

        value ^= 1 << bit;                              // <---- XOR flips this bit: 1 becomes 0, and 0 becomes 1.

        System.out.println(value);
    }
}
