/*
    ==== COUNTING CHARACTERS ====

    A frequency array stores how often each character appears. For ASCII input, a character
    value can index one of 128 counters. This bounded alphabet needs no hash map.

    Complexity: Time O(n + alphabet size), extra space O(alphabet size), constant for ASCII.
    Try: Find the first character whose frequency is exactly one.
*/

public class CharacterFrequency {
    static int[] count(String text) {
        int[] counts = new int[128];

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            if (c >= counts.length) {
                throw new IllegalArgumentException("ASCII input required");
            }

            counts[c]++;                               // <---- The character code chooses the counter for this character.
        }

        return counts;
    }

    public static void main(String[] args) {
        int[] counts = count("banana");

        for (int c = 0; c < counts.length; c++) {
            if (counts[c] > 0) {
                System.out.println((char) c + ": " + counts[c]);
            }
        }
    }
}
