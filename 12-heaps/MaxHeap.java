/*
    ==== MAX HEAP ====

    A max heap keeps its largest value at the root. Java PriorityQueue can act as a max heap when
    given a reversed comparison rule.

    Complexity: peek O(1); insert/remove root O(log n); space O(n).
    Try: Change the min-heap sample comparisons and extract values from largest to smallest.
*/

import java.util.Collections;
import java.util.PriorityQueue;

public class MaxHeap {
    public static void main(String[] args) {
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());       // <---- Reverse the comparator so poll removes the largest value first.

        max.add(4);
        max.add(9);
        max.add(2);

        while (!max.isEmpty()) {
            System.out.println(max.poll());
        }
    }
}
