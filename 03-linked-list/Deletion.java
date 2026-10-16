/*
    ==== DELETE THE FIRST MATCHING NODE ====

    To remove a node, make the previous node point past it. Removing the head needs a separate
    case because no node comes before it.

    Complexity: Search O(n); link update O(1); extra space O(1).
    Try: Delete the tail and a value that does not exist.
*/

public class Deletion {
    static class Node {
        int v;
        Node next;

        Node(int v) {
            this.v = v;
        }
    }

    static Node remove(Node head, int target) {
        if (head == null) {
            return null;
        }

        if (head.v == target) {                             // <---- Deleting the first node means returning its next node as the new head.
            return head.next;
        }

        Node p = head;

        while (p.next != null && p.next.v != target) {      // <---- Stop before the matching node so its next link can be skipped.
            p = p.next;
        }

        if (p.next != null) {
            p.next = p.next.next;
        }

        return head;
    }

    public static void main(String[] args) {
        Node h = new Node(1);

        h.next = new Node(2);
        h.next.next = new Node(3);
        h = remove(h, 2);

        for (Node n = h; n != null; n = n.next) {
            System.out.print(n.v + " ");
        }
    }
}
