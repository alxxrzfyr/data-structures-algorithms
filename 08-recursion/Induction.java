/*
    ==== PROVING A RECURSIVE RESULT ====

    Induction proves a base case, then proves a larger case assuming the smaller case works.
    sum(0) is 0. If sum(n - 1) gives the first n - 1 values, adding n gives the first n values.
    Each call also decreases n, so the method reaches its base case.

    Complexity: Time O(n), call-stack space O(n). Use small nonnegative inputs to avoid stack
    exhaustion and long overflow.
    Try: Write the base case and inductive step for factorial.
*/

public class Induction {
    static long sum(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("negative input");
        }

        if (n == 0) {
            return 0;
        }

        return n + sum(n - 1);                         // <---- Trust the smaller result only after proving the base case and this step.
    }

    public static void main(String[] args) {
        System.out.println(sum(5));
    }
}
