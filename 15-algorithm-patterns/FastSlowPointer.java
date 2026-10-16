/*
    ==== DETECT A LINKED-LIST CYCLE ====

    Move one pointer one link and another two links per step. If the list contains a cycle, their
    different speeds eventually bring them to the same node.

    Complexity: Time O(n), extra space O(1).
    Try: Remove the cycle and confirm the pointers stop without meeting.
*/

public class FastSlowPointer {
    static class Node {
        int value;
        Node next;

        Node(int v) {
            value = v;
        }
    }

    public static void main(String[] args) {
        Node a = new Node(1), b = new Node(2), c = new Node(3);

        a.next = b;
        b.next = c;
        c.next = b;

        Node slow = a, fast = a;

        do {
            if (fast == null || fast.next == null) {
                System.out.println(false);
                return;
            }

            slow = slow.next;                           // <---- Inside a cycle, fast eventually catches slow from behind.
            fast = fast.next.next;
        } while (slow != fast);

        System.out.println(true);
    }
}
