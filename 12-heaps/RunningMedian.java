/*
    ==== RUNNING MEDIAN WITH TWO HEAPS ====

    Keep the lower half in a max heap and the upper half in a min heap. Their sizes differ by at
    most one, with the lower half holding the extra value. Every lower value stays at most every
    upper value. The roots then identify the middle value or pair.

    Complexity: Each insertion takes O(log n), median lookup O(1), total storage O(n). An empty
    stream has no median.
    Try: Explain why averaging two int roots must widen to long before addition.
*/

import java.util.Collections;
import java.util.PriorityQueue;

public class RunningMedian {
    static class Median {
        PriorityQueue<Integer> lower = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> upper = new PriorityQueue<>();

        void add(int value) {
            if (lower.isEmpty() || value <= lower.peek()) {
                lower.offer(value);
            } else {
                upper.offer(value);
            }

            if (lower.size() > upper.size() + 1) {
                upper.offer(lower.poll());
            } else if (upper.size() > lower.size()) {
                lower.offer(upper.poll());             // <---- Restore the size rule while keeping the two halves ordered.
            }
        }

        double value() {
            if (lower.isEmpty()) {
                throw new IllegalStateException("empty stream");
            }

            if (lower.size() == upper.size()) {
                return ((long) lower.peek() + upper.peek()) / 2.0;
            }

            return lower.peek();
        }
    }

    public static void main(String[] args) {
        Median median = new Median();

        for (int value : new int[] {5, 1, 9, 3}) {
            median.add(value);
            System.out.println(median.value());
        }
    }
}
