/*
    ==== FREQUENCY COUNTING ====

    Frequency means how many times a value appears. A map stores each distinct value as a key and
    its count as the value.

    Complexity: Time O(n) expected, extra space O(k) for k distinct values.
    Try: Count words and convert them to lowercase first so Java and java share one count.
*/

import java.util.HashMap;
import java.util.Map;

public class FrequencyCounting {
    public static void main(String[] args) {
        int[] values = {2, 1, 2, 3, 1, 2};
        Map<Integer, Integer> counts = new HashMap<>();

        for (int value : values) {
            counts.put(value, counts.getOrDefault(value, 0) + 1);       // <---- Use 0 for a missing key, then add 1 for this occurrence.
        }

        System.out.println(counts);
    }
}
