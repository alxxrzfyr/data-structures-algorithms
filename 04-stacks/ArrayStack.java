/*
    ==== STACK WITH AN ARRAY ====

    A stack follows last in, first out: the newest item leaves first. This implementation uses an
    array and size to track the next free slot.

    Complexity: push/pop/peek O(1); space O(capacity).
    Try: Add a full-stack check before pushing.
*/

public class ArrayStack {
    static class IntStack {
        int[] items = new int[4];
        int size;

        void push(int value) {
            if (size == items.length) {
                throw new IllegalStateException("full");
            }

            items[size++] = value;                      // <---- Place the new value after the stored items; it becomes the top.
        }

        int pop() {
            if (size == 0) {
                throw new IllegalStateException("empty");
            }

            return items[--size];                       // <---- Reduce size first, then return the item that was at the top.
        }

        int peek() {
            if (size == 0) {
                throw new IllegalStateException("empty");
            }

            return items[size - 1];
        }
    }

    public static void main(String[] args) {
        IntStack stack = new IntStack();

        stack.push(10);
        stack.push(20);

        System.out.println(stack.pop());
    }
}
