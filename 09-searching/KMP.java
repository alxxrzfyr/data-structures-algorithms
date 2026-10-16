/*
    ==== REUSING MATCHES WITH KMP ====

    Naive search repeats comparisons after a partial match fails. KMP saves the longest proper
    prefix that is also a suffix for each pattern prefix. On a mismatch, that table preserves a
    matching suffix instead of restarting from zero. The text index never moves backward.

    Complexity: Time O(n + m), extra space O(m). Indexes use UTF-16 code units; an empty pattern
    matches at 0.
    Try: Build the prefix table for ababaca and trace every fallback.
*/

import java.util.Arrays;

public class KMP {
    static int[] prefix(String pattern) {
        int[] longest = new int[pattern.length()];
        int matched = 0;

        for (int i = 1; i < pattern.length(); i++) {
            while (matched > 0 && pattern.charAt(i) != pattern.charAt(matched)) {
                matched = longest[matched - 1];        // <---- Keep the next shorter prefix that could still match this suffix.
            }

            if (pattern.charAt(i) == pattern.charAt(matched)) {
                matched++;
            }

            longest[i] = matched;
        }

        return longest;
    }

    static int find(String text, String pattern) {
        if (pattern.isEmpty()) {
            return 0;
        }

        int[] longest = prefix(pattern);
        int matched = 0;

        for (int i = 0; i < text.length(); i++) {
            while (matched > 0 && text.charAt(i) != pattern.charAt(matched)) {
                matched = longest[matched - 1];
            }

            if (text.charAt(i) == pattern.charAt(matched)) {
                matched++;
            }

            if (matched == pattern.length()) {
                return i - matched + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(prefix("ababaca")));
        System.out.println(find("abababacaba", "ababaca"));
    }
}
