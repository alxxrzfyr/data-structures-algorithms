/*
    ==== QUEUE WITH LINKED NODES ====

    A linked queue keeps references to its first and last nodes. Enqueue adds after tail; dequeue
    removes head.

    Complexity: Enqueue/dequeue O(1); space O(n).
    Try: Remove the final item, then add another. Check that both head and tail are correct.
*/

public class LinkedQueue {
    static class Node {
        int value;
        Node next;

        Node(int v) {
            value = v;
        }
    }

    static class Queue {
        Node head, tail;

        void offer(int v) {
            Node n = new Node(v);

            if (tail == null) {                         // <---- If no tail exists, this new node must also become head.
                head = n;
            } else {
                tail.next = n;
            }

            tail = n;
        }

        int poll() {
            if (head == null) {
                throw new IllegalStateException();
            }

            int v = head.value;

            head = head.next;

            if (head == null) {
                tail = null;                            // <---- The queue is now empty, so tail must become null too.
            }

            return v;
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue();

        q.offer(3);
        q.offer(7);

        System.out.println(q.poll());
        System.out.println(q.poll());
    }
}
