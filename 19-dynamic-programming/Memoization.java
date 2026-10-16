/*
    ==== MEMOIZATION ====

    Memoization caches, or stores, the answer to each recursive subproblem. Check the cache first
    so the same input does not need to be solved again.

    Complexity: Time O(n), extra space O(n) for the cache and recursive call stack.
    Try: Write the plain recursive calls for n=5 and count how many times fib(2) appears.
*/

import java.util.Arrays;

public class Memoization {
    static int fib(int n, int[] memo) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be nonnegative");
        }

        if (n > 46) {
            throw new ArithmeticException("Fibonacci number exceeds int range");
        }

        if (n < 2) {
            return n;
        }

        if (memo[n] != -1) {                            // <---- This input already has a cached answer, so return it without more recursion.
            return memo[n];
        }

        memo[n] = fib(n - 1, memo) + fib(n - 2, memo);

        return memo[n];
    }

    public static void main(String[] args) {
        int[] memo = new int[11];

        Arrays.fill(memo, -1);

        System.out.println(fib(10, memo));
    }
}
