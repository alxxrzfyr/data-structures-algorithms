/*
    ==== QUEUE WITH A SHIFTING ARRAY ====

    A queue follows first in, first out: the oldest item leaves first. This simple array version
    shifts the remaining items left whenever it removes the front.

    Complexity: Enqueue O(1) if space exists; dequeue O(n) due to shifting; space O(capacity).
    Try: Compare this queue with the circular-queue lesson.
*/

public class ArrayQueue {
    static class Queue {
        int[] a = new int[5];
        int size;

        void offer(int v) {
            if (size == a.length) {
                throw new IllegalStateException("full");
            }

            a[size++] = v;
        }

        int poll() {
            if (size == 0) {
                throw new IllegalStateException();
            }

            int v = a[0];

            for (int i = 1; i < size; i++) {            // <---- Move the remaining items left; this is why removal takes O(n) time.
                a[i - 1] = a[i];
            }

            size--;

            return v;
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue();

        q.offer(10);
        q.offer(20);

        System.out.println(q.poll());
    }
}
