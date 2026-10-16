/*
    ==== PRIORITY QUEUE ====

    A priority queue removes an item according to a priority rule. Java's default integer order
    removes the smallest number first, even if it arrived later.

    Complexity: offer/poll O(log n); peek O(1).
    Try: Use Comparator.reverseOrder() to make the largest number come out first.
*/

import java.util.PriorityQueue;

public class PriorityQueueExample {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        queue.offer(7);
        queue.offer(2);
        queue.offer(5);

        while (!queue.isEmpty()) {                      // <---- poll removes the smallest number, not the oldest number.
            System.out.println(queue.poll());
        }
    }
}
