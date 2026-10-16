/*
    ==== FIRST IN, FIRST OUT ====

    A queue processes items in arrival order. offer adds at the back, and poll removes from the
    front.

    Complexity: offer and poll are amortized O(1): constant on average over many queue operations.
    Try: Call poll on an empty queue and observe its null result.
*/

import java.util.ArrayDeque;
import java.util.Queue;

public class FirstInFirstOut {
    public static void main(String[] args) {
        Queue<String> q = new ArrayDeque<>();

        q.offer("first");
        q.offer("second");

        System.out.println(q.poll());                   // <---- The first item added is the first item poll removes.
        System.out.println(q.poll());
    }
}
