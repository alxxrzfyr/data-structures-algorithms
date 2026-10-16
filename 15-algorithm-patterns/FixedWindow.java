/*
    ==== FIXED-SIZE SLIDING WINDOW ====

    Find the largest sum of exactly k consecutive values. Recomputing each window costs O(n *
    k). Move the window by subtracting the value leaving and adding the value entering. Unlike
    the variable positive-sum window, this fixed-size method also supports negative values.

    Complexity: Time O(n), extra space O(1). Require 1 <= k <= array length; long stores sums of
    int values.
    Try: Return the starting index of the best window, keeping the first index when sums tie.
*/

public class FixedWindow {
    static long maximum(int[] values, int k) {
        if (k < 1 || k > values.length) {
            throw new IllegalArgumentException("invalid window size");
        }

        long sum = 0;

        for (int i = 0; i < k; i++) {
            sum += values[i];
        }

        long best = sum;

        for (int right = k; right < values.length; right++) {
            sum += (long) values[right] - values[right - k];   // <---- Remove the old left edge and include the new right edge.
            best = Math.max(best, sum);
        }

        return best;
    }

    public static void main(String[] args) {
        System.out.println(maximum(new int[] {-2, 4, -1, 3, -5}, 3));
    }
}
