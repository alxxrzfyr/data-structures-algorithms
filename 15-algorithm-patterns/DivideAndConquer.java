/*
    ==== DIVIDE, SOLVE, COMBINE ====

    Divide and conquer splits a problem, solves each smaller part, and combines the results. Here,
    find each half's maximum and keep the larger one.

    Complexity: Merge sort takes O(n log n) time and O(n) extra space.
    Try: Trace how max splits the input and combines the returned maximums.
*/

public class DivideAndConquer {
    static int max(int[] a, int left, int right) {
        if (left < 0 || right > a.length || left >= right) {
            throw new IllegalArgumentException("range must be nonempty and within the array");
        }

        if (right - left == 1) {
            return a[left];
        }

        int mid = (left + right) / 2;                   // <---- Split at mid, find both maximums, then choose the larger result.

        return Math.max(max(a, left, mid), max(a, mid, right));
    }

    public static void main(String[] args) {
        int[] a = {3, 9, 2, 7, 4};

        System.out.println(max(a, 0, a.length));
    }
}
