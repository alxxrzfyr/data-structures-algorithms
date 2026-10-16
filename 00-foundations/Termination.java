/*
    ==== SHOWING THAT A LOOP STOPS ====

    A decreasing measure explains why a loop ends. Here remaining is a nonnegative integer, and
    every iteration makes it smaller. It cannot decrease forever while staying positive.

    Complexity: Time O(log n) for positive n, extra space O(1). Zero needs no steps.
    Try: Explain why subtracting zero would destroy this termination argument.
*/

public class Termination {
    static int halvings(int remaining) {
        if (remaining < 0) {
            throw new IllegalArgumentException("negative input");
        }

        int steps = 0;

        while (remaining > 0) {
            remaining /= 2;                            // <---- Integer division strictly decreases every positive remaining value.
            steps++;
        }

        return steps;
    }

    public static void main(String[] args) {
        System.out.println(halvings(16));
    }
}
