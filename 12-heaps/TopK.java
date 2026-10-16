/*
    ==== KEEPING THE LARGEST K VALUES ====

    Sorting all values costs O(n log n). Instead keep a min heap of at most k values. Whenever
    it grows too large, remove its smallest value. Every rejected value is no larger than the
    retained candidates. Polling produces the retained values in ascending order.

    Complexity: Time O(n log(k + 2)), extra space O(k), for 0 <= k <= n. Duplicate values count
    separately.
    Try: Keep the smallest k values using a max heap.
*/

import java.util.Arrays;
import java.util.PriorityQueue;

public class TopK {
    static int[] largest(int[] values, int k) {
        if (k < 0 || k > values.length) {
            throw new IllegalArgumentException("invalid k");
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int value : values) {
            heap.offer(value);

            if (heap.size() > k) {
                heap.poll();                           // <---- The smallest candidate cannot belong to the largest k seen so far.
            }
        }

        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = heap.poll();
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(largest(new int[] {5, 1, 9, 3, 9, 2}, 3)));
    }
}
