/*
    ==== LINEAR SEARCH ====

    Linear search checks items one by one. Return the first matching index, or -1 if the target is
    absent.

    Complexity: Time O(n), extra space O(1).
    Try: Return the first matching index when a value occurs more than once.
*/

public class LinearSearch {
    static int find(int[] values, int target) {
        for (int i = 0; i < values.length; i++) {       // <---- Return as soon as a match is found; later items need no check.
            if (values[i] == target) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(find(new int[] {8, 3, 5, 3}, 3));
    }
}
