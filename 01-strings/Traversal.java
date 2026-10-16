/*
    ==== STRINGS AS INDEXED TEXT ====

    A String stores immutable text: operations do not change its contents. charAt reads one
    UTF-16 code unit by index. These examples use ASCII text; a later lesson explains characters
    that use two code units.

    Complexity: Traversal takes O(n) time and O(1) extra space.
    Try: Read the same string backward using indexes without building a second string.
*/

public class Traversal {
    public static void main(String[] args) {
        String word = "java";

        for (int i = 0; i < word.length(); i++) {
            System.out.println(i + ": " + word.charAt(i));   // <---- Indexes start at zero and stop before length.
        }

        String upper = word.toUpperCase(java.util.Locale.ROOT);

        System.out.println(word);
        System.out.println(upper);
    }
}
