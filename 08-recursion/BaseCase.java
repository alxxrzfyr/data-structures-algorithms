/*
    ==== THE BASE CASE ====

    A recursive method calls itself. Its base case is the stopping condition: an input small
    enough to answer without another recursive call.

    Complexity: Countdown takes O(n) time and O(n) call-stack space for a starting value n >= 0.
    Try: Remove the base case and observe what happens to the call stack.
*/

public class BaseCase {
    static void countDown(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be nonnegative");
        }

        if (n == 0) {                                   // <---- n reaches 0, so this call can stop instead of calling itself again.
            System.out.println("done");
            return;
        }

        System.out.println(n);

        countDown(n - 1);
    }

    public static void main(String[] args) {
        countDown(3);
    }
}
