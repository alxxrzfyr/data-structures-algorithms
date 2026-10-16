/*
    ==== FACTORIAL ====

    Factorial multiplies all positive integers up to n. Recursion calculates n * factorial(n - 1),
    stopping at 0 or 1.

    Complexity: Time O(n), call-stack space O(n).
    Try: Trace factorial(4) until the base case, then trace returned values.
*/

public class Factorial {
    static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be nonnegative");
        }

        if (n > 20) {
            throw new ArithmeticException("factorial exceeds long range");
        }

        if (n <= 1) {                                   // <---- Both 0! and 1! are 1, so no smaller call is needed.
            return 1;
        }

        return n * factorial(n - 1);                    // <---- Ask for the smaller factorial, then multiply its answer by n.
    }

    public static void main(String[] args) {
        System.out.println(factorial(5));
    }
}
