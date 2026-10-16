/*
    ==== PRIORITYQUEUE AS A HEAP ====

    Java PriorityQueue is a min heap by default: peek reads its smallest item and poll removes it.
    Use repeated poll calls to read items in sorted order.

    Complexity: offer/poll O(log n), peek O(1).
    Try: Supply a comparator to order tasks by a field.
*/

import java.util.PriorityQueue;

public class PriorityQueueExample {
    public static void main(String[] args) {
        PriorityQueue<String> q = new PriorityQueue<>();

        q.add("medium");
        q.add("urgent");
        q.add("low");

        while (!q.isEmpty()) {                          // <---- Strings come out alphabetically here; a normal iterator is not sorted.
            System.out.println(q.poll());
        }
    }
}
