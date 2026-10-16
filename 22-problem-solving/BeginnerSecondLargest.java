/*
    ==== PRACTICE SECOND DISTINCT LARGEST ====

    Problem: return the second-largest distinct int in an array, or null when fewer than two
    distinct values exist. Keep two candidates during one scan. Example: [4, 9, 9, 2, 7] returns
    7. Sorting is a useful starting approach but does more work.

    Complexity: Time O(n), extra space O(1). Empty input returns null.
    Try: Handle Integer.MIN_VALUE without using it as a missing-value marker.
*/

public class BeginnerSecondLargest {
    static Integer find(int[] values) {
        Integer largest = null, second = null;

        for (int value : values) {
            if (largest == null || value > largest) {
                second = largest;
                largest = value;
            } else if (value < largest && (second == null || value > second)) {
                second = value;                        // <---- Ignore a duplicate maximum while improving the second distinct candidate.
            }
        }

        return second;
    }

    public static void main(String[] args) {
        System.out.println(find(new int[] {4, 9, 9, 2, 7}));
    }
}
