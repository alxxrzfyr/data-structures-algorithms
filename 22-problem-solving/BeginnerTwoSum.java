/*
    ==== TWO SUM BY CHECKING EVERY PAIR ====

    Find two different array indexes whose values add to the target. Check every pair first to get
    a simple, correct brute-force solution.

    Complexity: Time O(n²), extra space O(1).
    Try: Stop after the first valid pair and report when no pair exists.
*/

public class BeginnerTwoSum {
    public static void main(String[] args) {
        int[] a = {2, 7, 11, 15};
        int target = 9;

        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {    // <---- j starts after i, so an item is not paired with itself or checked twice.
                if (a[i] + a[j] == target) {
                    System.out.println(i + ", " + j);
                }
            }
        }
    }
}
