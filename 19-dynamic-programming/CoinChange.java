/*
    ==== MINIMUM COIN CHANGE ====

    Let dp[a] store the fewest coins needed for amount a. For each possible last coin, reuse the
    answer for the amount left over and add one coin.

    Complexity: Time O(amount × number of coin values), space O(amount).
    Try: Count the different coin combinations instead of minimizing the number of coins.
*/

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {1, 3, 4};
        int amount = 6;
        int[] dp = new int[amount + 1];

        Arrays.fill(dp, amount + 1);
        dp[0] = 0;                                              // <---- The base case is amount 0, which needs no coins.

        for (int a = 1; a <= amount; a++) {
            for (int c : coins) {
                if (c <= a) {
                    dp[a] = Math.min(dp[a], dp[a - c] + 1);     // <---- Use coin c, then add 1 to the best answer for the remaining amount.
                }
            }
        }

        System.out.println(dp[amount] > amount ? -1 : dp[amount]);
    }
}
