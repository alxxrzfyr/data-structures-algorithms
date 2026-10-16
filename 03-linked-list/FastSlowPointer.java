/*
    ==== FIND THE MIDDLE NODE ====

    Move slow one link at a time and fast two links at a time. When fast reaches the end, slow is
    at a middle node.

    Complexity: Time O(n), extra space O(1).
    Try: Decide which middle node is returned for an even-length list.
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
        Node a = new Node(1), b = new Node(2), c = new Node(3), d = new Node(4), e = new Node(5);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        Node slow = a, fast = a;

        while (fast != null && fast.next != null) {     // <---- fast covers twice as many links, so slow ends near the halfway point.
            slow = slow.next;
            fast = fast.next.next;
        }

        System.out.println(slow.value);
    }
}
