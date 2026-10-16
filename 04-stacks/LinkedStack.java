/*
    ==== STACK WITH LINKED NODES ====

    Use a linked list's head as the stack's top. push adds a new head, and pop removes that head.

    Complexity: push and pop take O(1) time; node storage takes O(n) space for n items.
    Try: Draw the head link after each push and pop.
*/

public class LinkedStack {
    static class Node {
        int value;
        Node next;

        Node(int v, Node n) {
            value = v;
            next = n;
        }
    }

    static class Stack {
        Node top;

        void push(int v) {
            top = new Node(v, top);                     // <---- The new node becomes top and points to the older stack items.
        }

        int pop() {
            if (top == null) {
                throw new IllegalStateException("empty");
            }

            int v = top.value;

            top = top.next;                             // <---- The old top was removed, so its next node becomes the new top.

            return v;
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();

        s.push(5);
        s.push(9);

        System.out.println(s.pop());
    }
}
