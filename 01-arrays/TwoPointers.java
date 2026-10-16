/*
    ==== TWO POINTERS ON A SORTED ARRAY ====

    Two pointers are two indexes that move through the same array. In sorted input, their sum
    tells us which index can move closer to the answer.

    Complexity: Time O(n), extra space O(1).
    Try: Choose a target smaller than every pair sum and trace how the indexes move.
*/

public class TwoPointers {
    public static void main(String[] args) {
        int[] values = {1, 3, 4, 6, 8};
        int target = 10, left = 0, right = values.length - 1;

        while (left < right) {                          // <---- Sorted values tell us which end cannot make the target sum.
            int sum = values[left] + values[right];

            if (sum == target) {
                System.out.println(left + ", " + right);
                return;
            }

            if (sum < target) {                         // <---- If the sum is too small, move left up; otherwise move right down.
                left++;
            } else {
                right--;
            }
        }

        System.out.println("No pair");
    }
}
