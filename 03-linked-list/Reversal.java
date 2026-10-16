/*
    ==== REVERSE A SINGLY LINKED LIST ====

    Reverse a list by making each next reference point to the previous node. Save the original
    next node first so you can continue along the list.

    Complexity: Time O(n), extra space O(1).
    Try: Trace previous, current, and next on a three-node list.
*/

public class Reversal {
    static class Node {
        int value;
        Node next;

        Node(int v) {
            value = v;
        }
    }

    static Node reverse(Node head) {
        Node previous = null, current = head;

        while (current != null) {
            Node next = current.next;                   // <---- Save the next node before changing the link, or you could lose the rest.

            current.next = previous;                    // <---- Reverse this link, then move on using the saved next node.
            previous = current;
            current = next;
        }

        return previous;
    }

    public static void main(String[] args) {
        Node a = new Node(1), b = new Node(2), c = new Node(3);

        a.next = b;
        b.next = c;

        for (Node n = reverse(a); n != null; n = n.next) {
            System.out.println(n.value);
        }
    }
}
