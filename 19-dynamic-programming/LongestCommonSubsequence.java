/*
    ==== LONGEST COMMON SUBSEQUENCE ====

    A subsequence keeps characters in order but can skip some. dp[i][j] stores the longest common
    subsequence length for the first i and j characters of the two strings.

    Complexity: Time and space O(m * n); m and n are the two string lengths.
    Try: Trace a small table and find which earlier cells supply each new answer.
*/

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String a = "stone", b = "longest";
        int[][] dp = new int[a.length() + 1][b.length() + 1];

        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                dp[i][j] =                              // <---- If characters match, use dp[i - 1][j - 1] + 1; otherwise skip one.
                        a.charAt(i - 1) == b.charAt(j - 1)
                                ? dp[i - 1][j - 1] + 1
                                : Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        System.out.println(dp[a.length()][b.length()]);
    }
}
