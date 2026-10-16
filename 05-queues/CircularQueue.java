/*
    ==== CIRCULAR QUEUE ====

    A circular queue reuses an array's empty slots by wrapping its indexes back to 0. It avoids
    shifting items after removing the front.

    Complexity: offer and poll take O(1) time; fixed-array storage takes O(capacity) space.
    Try: Fill, remove twice, then add twice to see the tail wrap around.
*/

public class CircularQueue {
    static class RingQueue {
        int[] data = new int[4];
        int head, size;

        void offer(int value) {
            if (size == data.length) {
                throw new IllegalStateException("full");
            }

            data[(head + size) % data.length] = value;      // <---- The remainder operator % wraps the index when it reaches the array end.
            size++;
        }

        int poll() {
            if (size == 0) {
                throw new IllegalStateException("empty");
            }

            int value = data[head];

            head = (head + 1) % data.length;                // <---- Move head to the next slot, wrapping to 0 when needed.
            size--;

            return value;
        }
    }

    public static void main(String[] args) {
        RingQueue q = new RingQueue();

        q.offer(1);
        q.offer(2);

        System.out.println(q.poll());

        q.offer(3);

        System.out.println(q.poll());
    }
}
