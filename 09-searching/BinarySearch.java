/*
    ==== BINARY SEARCH ====

    Binary search needs sorted input. Compare the target with the middle value, then keep only the
    half that could still contain it.

    Complexity: Time O(log n), extra space O(1).
    Try: Search an empty array and targets below and above all stored values.
*/

public class BinarySearch {
    static int find(int[] a, int target) {
        int left = 0, right = a.length - 1;

        while (left <= right) {                         // <---- left and right are included; stop when they cross.
            int mid = left + (right - left) / 2;

            if (a[mid] == target) {
                return mid;
            }

            if (a[mid] < target) {                      // <---- A middle value below target rules out it and every value to its left.
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(find(new int[] {1, 3, 5, 7, 9}, 7));
    }
}
