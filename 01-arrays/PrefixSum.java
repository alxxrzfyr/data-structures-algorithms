/*
    ==== PREFIX SUM ====

    A prefix sum is a running total from the start of an array. Store these totals once, then
    subtract two of them to get a range sum.

    Complexity: Build O(n), each range sum O(1), extra space O(n); n is the array length.
    Try: Change left and right, including left = 0. Include both endpoints in each sum.
*/

public class PrefixSum {
    public static void main(String[] args) {
        int[] values = {3, 1, 4, 2};
        int[] prefix = new int[values.length + 1];

        for (int i = 0; i < values.length; i++) {                   // <---- prefix[i + 1] adds this item to the earlier total; prefix[0] is 0.
            prefix[i + 1] = prefix[i] + values[i];
        }

        int left = 1, right = 3;

        System.out.println(prefix[right + 1] - prefix[left]);       // <---- Subtract the total before left to keep values from left through right.
    }
}
