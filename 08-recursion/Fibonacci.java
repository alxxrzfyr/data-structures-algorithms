/*
    ==== FIBONACCI AND REPEATED WORK ====

    Each Fibonacci number is the sum of the previous two. Memoization stores answers in an array
    so repeated recursive calls can reuse them.

    Complexity: This memoized version takes O(n) time and space. Without caching, the repeated
    calls grow exponentially.
    Try: Count recursive calls, then compare them with a version that does not use the memo array.
*/

import java.util.Arrays;

public class Fibonacci {
    static long fib(int n, long[] memo) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be nonnegative");
        }

        if (n > 92) {
            throw new ArithmeticException("Fibonacci number exceeds long range");
        }

        if (n < 2) {
            return n;
        }

        if (memo[n] != -1) {                                        // <---- A value other than -1 means this answer was already calculated.
            return memo[n];
        }

        return memo[n] = fib(n - 1, memo) + fib(n - 2, memo);       // <---- Store the answer before returning, so later calls can reuse it.
    }

    public static void main(String[] args) {
        int n = 40;
        long[] memo = new long[n + 1];

        Arrays.fill(memo, -1);

        System.out.println(fib(n, memo));
    }
}
