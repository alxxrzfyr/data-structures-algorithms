/*
    ==== CLIMBING STAIRS ====

    Count ways to reach step n using moves of one or two steps. The final move must come from n -
    1 or n - 2, so add those two counts.

    Complexity: Time O(n), space O(n), reducible to O(1).
    Try: Allow moves of 1 or 3 steps and write the new recurrence before editing the loop.
*/

public class ClimbingStairs {
    public static void main(String[] args) {
        int n = 6;
        int[] ways = new int[n + 1];

        ways[0] = 1;                                    // <---- There is one way to reach step 0: take no steps.

        for (int i = 1; i <= n; i++) {
            ways[i] += ways[i - 1];                     // <---- Add the ways that reach here with a final one-step move.

            if (i >= 2) {
                ways[i] += ways[i - 2];
            }
        }

        System.out.println(ways[n]);
    }
}
