/*
    ==== SHIFT BITS ====

    A bit shift moves binary digits left or right. Left shifts can multiply by powers of two, but
    large values may overflow. Java's >> keeps the sign bit; >>> fills with zeros.

    Complexity: One primitive shift is O(1).
    Try: Compare >> and >>> on a negative integer.
*/

public class Shifting {
    public static void main(String[] args) {
        int value = 12;

        System.out.println(value << 1);                 // <---- For this small value, shifting left once multiplies it by 2.
        System.out.println(value >> 2);
        System.out.println(-8 >> 1);                    // <---- >> copies the sign bit, while >>> adds zeros at the left.
        System.out.println(-8 >>> 1);
    }
}
