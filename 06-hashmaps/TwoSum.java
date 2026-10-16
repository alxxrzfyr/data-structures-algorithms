/*
    ==== TWO SUM WITH A MAP ====

    For each value, calculate its complement: target minus that value. Look for the complement in
    a map of earlier values and their indexes.

    Complexity: Expected time O(n), extra space O(n).
    Try: Explain why the current value is added after checking for its complement.
*/

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] a = {2, 7, 11, 15};
        int target = 9;
        Map<Integer, Integer> index = new HashMap<>();

        for (int i = 0; i < a.length; i++) {
            int need = target - a[i];                   // <---- The complement is the earlier value needed to reach the target.

            if (index.containsKey(need)) {
                System.out.println(index.get(need) + ", " + i);
                return;
            }

            index.put(a[i], i);                         // <---- Store this index after checking, so an item cannot match itself.
        }
    }
}
