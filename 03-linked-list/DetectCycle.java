/*
    ==== DETECT A CYCLE ====

    A cycle is a chain of next references that loops back to an earlier node. Floyd's algorithm
    detects it by moving two pointers at different speeds.

    Complexity: Time O(n), extra space O(1).
    Try: Break the loop and confirm the result becomes false.
*/

public class DetectCycle {
    static class Node {
        int v;
        Node next;

        Node(int v) {
            this.v = v;
        }
    }

    static boolean hasCycle(Node head) {
        Node slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;                           // <---- slow moves one link while fast moves two links.
            fast = fast.next.next;

            if (slow == fast) {                         // <---- If both references reach the same node, the list has a cycle.
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Node a = new Node(1), b = new Node(2), c = new Node(3);

        a.next = b;
        b.next = c;
        c.next = b;

        System.out.println(hasCycle(a));
    }
}
