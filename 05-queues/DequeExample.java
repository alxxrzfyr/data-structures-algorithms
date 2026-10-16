/*
    ==== DOUBLE-ENDED QUEUE ====

    A deque, short for double-ended queue, allows insertion and removal at both ends. The same
    structure can act as a queue or a stack.

    Complexity: End operations are amortized O(1): usually constant time, with occasional array
    resizing.
    Try: Use the same deque first as a queue and then as a stack.
*/

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeExample {
    public static void main(String[] args) {
        Deque<String> line = new ArrayDeque<>();

        line.offerLast("A");
        line.offerLast("B");
        line.offerFirst("urgent");                      // <---- offerFirst adds at the front; offerLast adds at the back.

        System.out.println(line.pollFirst());
        System.out.println(line.pollLast());
    }
}
