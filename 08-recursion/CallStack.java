/*
    ==== CALLS ON THE STACK ====

    The call stack remembers unfinished method calls. Each recursive call keeps its own local
    variables while waiting for the next call to return.

    Complexity: Time O(n), call-stack space O(n); there is one unfinished call for each smaller
    positive n.
    Try: Draw the pending calls for sum(3) and the order in which they return.
*/

public class CallStack {
    static int sum(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be nonnegative");
        }

        if (n == 0) {
            return 0;
        }

        int answer = n + sum(n - 1);                    // <---- This addition waits until sum(n - 1) returns its answer.

        System.out.println("returning from " + n);

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(sum(3));
    }
}
