/*
    ==== MERGE OVERLAPPING INTERVALS ====

    An interval is a range with a start and an end. Sort intervals by start, then merge the next
    one into the last result if their ranges overlap.

    Complexity: Time O(n log n) for sorting; output space O(n).
    Try: Decide whether intervals that only touch at an endpoint should merge.
*/

import java.util.*;

public class MediumMergeIntervals {
    public static void main(String[] args) {
        int[][] a = {{1, 3}, {2, 6}, {8, 10}, {9, 12}};

        Arrays.sort(a, Comparator.comparingInt(x -> x[0]));                 // <---- Sorting by start puts overlapping ranges next to each other.

        List<int[]> out = new ArrayList<>();

        for (int[] x : a) {
            if (out.isEmpty() || x[0] > out.get(out.size() - 1)[1]) {       // <---- No overlap means this range starts a separate output interval.
                out.add(x.clone());
            } else {
                out.get(out.size() - 1)[1] = Math.max(out.get(out.size() - 1)[1], x[1]);
            }
        }

        for (int[] x : out) {
            System.out.println(Arrays.toString(x));
        }
    }
}
