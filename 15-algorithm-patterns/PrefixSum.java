/*
    ==== COUNT SUBARRAYS WITH A TARGET SUM ====

    A prefix sum is the total up to the current position. Two prefix totals differ by the sum
    between them. A map counts earlier totals that form the target sum.

    Complexity: Expected time O(n), extra space O(n).
    Try: Include negative values and check each reported count by listing the matching subarrays.
*/

import java.util.HashMap;
import java.util.Map;

public class PrefixSum {
    public static void main(String[] args) {
        int[] a = {1, -1, 1, 1};
        int target = 2, sum = 0, count = 0;
        Map<Integer, Integer> seen = new HashMap<>();

        seen.put(0, 1);                                     // <---- Record the total before the array starts so ranges can begin at index 0.

        for (int v : a) {
            sum += v;
            count += seen.getOrDefault(sum - target, 0);    // <---- Every earlier total of sum - target gives one matching subarray.
            seen.put(sum, seen.getOrDefault(sum, 0) + 1);
        }

        System.out.println(count);
    }
}
