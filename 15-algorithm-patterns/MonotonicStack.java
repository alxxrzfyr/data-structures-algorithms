/*
    ==== NEXT GREATER VALUE WITH A MONOTONIC STACK ====

    A monotonic stack keeps candidates in a consistent value order. Scan from right to left and
    remove values no greater than the current one. They cannot be the current answer, and the
    current value is a closer candidate for earlier positions.

    Complexity: Time O(n), extra space O(n), versus O(n squared) repeated scans. Every index is
    pushed and popped at most once. Results are indexes, with -1 for no answer.
    Try: Change the comparisons to find the next strictly smaller value.
*/

import java.util.Arrays;

public class MonotonicStack {
    static int[] nextGreater(int[] values) {
        int[] stack = new int[values.length];
        int[] answer = new int[values.length];
        int size = 0;

        Arrays.fill(answer, -1);

        for (int i = values.length - 1; i >= 0; i--) {
            while (size > 0 && values[stack[size - 1]] <= values[i]) {
                size--;                                // <---- A value no larger than this one cannot be its strictly greater answer.
            }

            if (size > 0) {
                answer[i] = stack[size - 1];
            }

            stack[size++] = i;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreater(new int[] {2, 1, 2, 4, 3})));
    }
}
