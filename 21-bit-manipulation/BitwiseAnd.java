/*
    ==== BITWISE AND ====

    Bitwise AND compares matching bit positions. A result bit is 1 only when both input bits are
    1. A mask lets you test selected bit positions.

    Complexity: One primitive integer operation is O(1).
    Try: Use value & 1 to test whether a number is odd.
*/

public class BitwiseAnd {
    public static void main(String[] args) {
        int value = 10;
        int mask = 6;

        System.out.println(value & mask);                           // <---- A bit survives only when both value and mask have 1 at that position.
        System.out.println((value & 1) == 1 ? "odd" : "even");      // <---- The lowest bit is 1 for odd integers and 0 for even integers.
    }
}
