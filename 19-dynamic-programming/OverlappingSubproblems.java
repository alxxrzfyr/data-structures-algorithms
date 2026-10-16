/*
    ==== OVERLAPPING SUBPROBLEMS ====

    Subproblems overlap when different recursive calls solve the same smaller input. Count
    Fibonacci calls to see the repeated work that memoization can remove.

    Complexity: Naive Fibonacci O(2ⁿ); each memoized state is solved once for O(n) time.
    Try: Draw the call tree for fib(5) and circle repeated calls.
*/

public class OverlappingSubproblems {
    static int calls;

    static int fib(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be nonnegative");
        }

        calls++;                                        // <---- Count every call, including calls that repeat an earlier input.

        if (n < 2) {
            return n;
        }

        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(fib(8));
        System.out.println("calls=" + calls);
    }
}
