/*
    ==== XOR AND SINGLE NUMBER ====

    XOR returns 0 for equal bits. Since x ^ x is 0, values that appear in pairs cancel out. This
    finds the single value when every other value appears exactly twice.

    Complexity: Time O(n), extra space O(1).
    Try: Try two unpaired values and explain why this one-result method cannot return both.
*/

public class Xor {
    public static void main(String[] args) {
        int[] a = {4, 1, 2, 1, 2};
        int answer = 0;

        for (int v : a) {
            answer ^= v;                                // <---- Each equal pair cancels, leaving the value that appears only once.
        }

        System.out.println(answer);
    }
}
