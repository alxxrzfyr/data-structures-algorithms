/*
    ==== REVERSE A STRING RECURSIVELY ====

    Recursively reverse the text after its first character. Add that first character to the end of
    the returned text.

    Complexity: Time O(n²) from copying text. Copied substrings can also use O(n²) space; stack
    depth is O(n).
    Try: Use a char array and two pointers to avoid repeated string copying.
*/

public class RecursiveStringReversal {
    static String reverse(String text) {
        if (text.length() < 2) {
            return text;
        }

        return reverse(text.substring(1)) + text.charAt(0);     // <---- Reverse everything after the first character, then append that character.
    }

    public static void main(String[] args) {
        System.out.println(reverse("java"));
    }
}
