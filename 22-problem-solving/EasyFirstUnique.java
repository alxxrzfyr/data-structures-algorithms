/*
    ==== PRACTICE FIRST UNIQUE CHARACTER ====

    Problem: return the index of the first ASCII character appearing exactly once, or -1 if none
    exists. Count frequencies first, then scan in the original order. Example: swiss returns
    index 1. The smallest character code is not necessarily the first unique character.

    Complexity: Time O(n), extra space O(128), constant for ASCII.
    Try: Return the character itself while distinguishing an absent answer from a valid
    character.
*/

public class EasyFirstUnique {
    static int index(String text) {
        int[] count = new int[128];

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            if (c >= count.length) {
                throw new IllegalArgumentException("ASCII input required");
            }

            count[c]++;
        }

        for (int i = 0; i < text.length(); i++) {
            if (count[text.charAt(i)] == 1) {
                return i;                              // <---- Original order decides which unique character is first.
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(index("swiss"));
    }
}
