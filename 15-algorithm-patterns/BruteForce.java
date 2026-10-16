/*
    ==== BRUTE-FORCE TWO SUM ====

    Brute force checks every possible pair. It is easy to verify and gives us a starting solution
    to compare with faster methods.

    Complexity: Time O(n²), extra space O(1).
    Try: Count how many pairs are checked as the input grows.
*/

public class BruteForce {
    public static void main(String[] args) {
        int[] a = {4, 7, 1, 9};
        int target = 10;

        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {    // <---- Starting at i + 1 avoids using one item twice or repeating reversed pairs.
                if (a[i] + a[j] == target) {
                    System.out.println(i + ", " + j);
                }
            }
        }
    }
}
