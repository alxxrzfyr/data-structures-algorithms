/*
    ==== NAIVE SUBSTRING SEARCH ====

    Try each possible starting position and compare the pattern from left to right. A mismatch
    moves the starting position forward by one. String.indexOf provides a built-in operation
    with the same first-match meaning; its implementation is not specified by this example.

    Complexity: Worst time O(n * m), extra space O(1), for text length n and pattern length m.
    Empty pattern matches at 0. Indexes count UTF-16 code units.
    Try: Count repeated comparisons for text aaaaaab and pattern aaab.
*/

public class SubstringSearch {
    static int find(String text, String pattern) {
        for (int start = 0; start <= text.length() - pattern.length(); start++) {
            int matched = 0;

            while (matched < pattern.length() && text.charAt(start + matched) == pattern.charAt(matched)) {
                matched++;
            }

            if (matched == pattern.length()) {
                return start;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(find("banana", "ana"));
        System.out.println("banana".indexOf("ana"));   // <---- Compare the manual result with Java's first-match operation.
    }
}
