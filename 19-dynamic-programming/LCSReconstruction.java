/*
    ==== RECOVERING A COMMON SUBSEQUENCE ====

    An LCS table stores lengths, but its dependencies also reveal a solution. Matching
    characters belong to the backward path. Otherwise move to a neighbor with the same optimal
    length. Reverse the collected characters to recover one longest common subsequence. This
    example uses ASCII text.

    Complexity: Time and space O(m * n); reconstruction takes O(m + n). Multiple different
    optimal subsequences may exist.
    Try: Change the tie-breaking rule and check that the result length remains optimal.
*/

public class LCSReconstruction {
    static String find(String first, String second) {
        int[][] length = new int[first.length() + 1][second.length() + 1];

        for (int i = 1; i <= first.length(); i++) {
            for (int j = 1; j <= second.length(); j++) {
                length[i][j] = first.charAt(i - 1) == second.charAt(j - 1)
                        ? length[i - 1][j - 1] + 1
                        : Math.max(length[i - 1][j], length[i][j - 1]);
            }
        }

        StringBuilder reversed = new StringBuilder();
        int i = first.length(), j = second.length();

        while (i > 0 && j > 0) {
            if (first.charAt(i - 1) == second.charAt(j - 1)) {
                reversed.append(first.charAt(i - 1));   // <---- A diagonal move records a character shared by both prefixes.
                i--;
                j--;
            } else if (length[i - 1][j] >= length[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        return reversed.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(find("abcde", "ace"));
    }
}
