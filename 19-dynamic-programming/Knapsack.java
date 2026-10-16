/*
    ==== 0/1 KNAPSACK ====

    In 0/1 knapsack, each item can be taken once or skipped. dp[i][c] stores the best value using
    the first i items within capacity c.

    Complexity: Time O(items × capacity), space O(items × capacity), reducible to O(capacity).
    Try: Process capacities backward if using a one-dimensional table so an item is not reused.
*/

public class Knapsack {
    public static void main(String[] args) {
        int[] w = {2, 3, 4}, v = {4, 5, 7};
        int cap = 5;
        int[][] dp = new int[w.length + 1][cap + 1];

        for (int i = 1; i <= w.length; i++) {
            for (int c = 0; c <= cap; c++) {
                dp[i][c] = dp[i - 1][c];                // <---- Skipping this item keeps the previous row's best value.

                if (w[i - 1] <= c) {                    // <---- Taking the item also uses the previous row, preventing reuse of that item.
                    dp[i][c] = Math.max(dp[i][c], dp[i - 1][c - w[i - 1]] + v[i - 1]);
                }
            }
        }

        System.out.println(dp[w.length][cap]);
    }
}
