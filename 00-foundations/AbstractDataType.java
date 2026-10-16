/*
    ==== ABSTRACT DATA TYPES ====

    An abstract data type describes allowed operations and their behavior. A stack promises
    last-in, first-out access whether its storage uses an array or linked nodes.

    Complexity: This fixed array implementation uses O(1) push/pop time and O(capacity) storage.
    Try: Describe the same push/pop contract for a linked stack without changing what callers
    expect.
*/

public class AbstractDataType {
    static class Stack {
        private int[] values = new int[3];
        private int size;

        void push(int value) {
            if (size == values.length) {
                throw new IllegalStateException("full");
            }

            values[size++] = value;
        }

        int pop() {
            if (size == 0) {
                throw new IllegalStateException("empty");
            }

            return values[--size];                     // <---- The newest stored item is always removed first.
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack();

        stack.push(10);
        stack.push(20);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
