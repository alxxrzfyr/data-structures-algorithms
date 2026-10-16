/*
    ==== ANAGRAMS BY CHARACTER COUNTS ====

    Anagrams use the same characters with the same frequencies, possibly in another order. Add
    counts for the first string and subtract counts for the second. Every count must return to
    zero. Inputs here must contain lowercase English letters only.

    Complexity: Time O(n + m), extra space O(26).
    Try: Explain why matching the set of characters without their counts is insufficient.
*/

public class Anagram {
    static boolean matches(String first, String second) {
        int[] counts = new int[26];

        for (String text : new String[] {first, second}) {
            for (int i = 0; i < text.length(); i++) {
                if (text.charAt(i) < 'a' || text.charAt(i) > 'z') {
                    throw new IllegalArgumentException("lowercase letters required");
                }
            }
        }

        if (first.length() != second.length()) {
            return false;
        }

        for (int i = 0; i < first.length(); i++) {
            counts[first.charAt(i) - 'a']++;
            counts[second.charAt(i) - 'a']--;          // <---- Equal character frequencies cancel, regardless of position.
        }

        for (int count : counts) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(matches("listen", "silent"));
        System.out.println(matches("aab", "abb"));
    }
}
