/*
    ==== TABULATION ====

    Tabulation is dynamic programming with a table filled in dependency order. Start with base
    cases, then calculate larger answers using values already stored.

    Complexity: For Fibonacci, O(n) time and O(n) space; only the last two values are needed, so
    space can be O(1).
    Try: Replace the array with two rolling variables.
*/

public class Tabulation {
    public static void main(String[] args) {
        int n = 10;
        int[] dp = new int[n + 1];

        dp[0] = 0;

        if (n > 0) {
            dp[1] = 1;
        }

        for (int i = 2; i <= n; i++) {                  // <---- Fill left to right so the previous two Fibonacci values are ready.
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        System.out.println(dp[n]);
    }
}
