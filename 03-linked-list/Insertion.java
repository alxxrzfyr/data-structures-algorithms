/*
    ==== INSERT AT THE HEAD OF A LIST ====

    The head reference identifies the first node. To insert at the head, point a new node at the
    old head, then make it the new head.

    Complexity: Time O(1), extra space O(1) per node.
    Try: Insert three values at the head and compare the resulting order.
*/

public class Insertion {
    static class Node {
        int v;
        Node next;

        Node(int v, Node n) {
            this.v = v;
            next = n;
        }
    }

    public static void main(String[] args) {
        Node head = null;

        for (int v : new int[] {10, 20, 30}) {
            head = new Node(v, head);                   // <---- Link the new node to the old head so the existing nodes stay connected.
        }

        for (Node n = head; n != null; n = n.next) {
            System.out.println(n.v);
        }
    }
}
