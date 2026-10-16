/*
    ==== CIRCULAR LINKED LIST ====

    A circular linked list connects its last node back to the first. Stop traversal when you
    return to the starting node, since no final link is null.

    Complexity: One full traversal O(n); insert at a known tail O(1).
    Try: Add an empty-list case and make one cycle without looping forever.
*/

public class CircularLinkedList {
    static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Node first = new Node(10), second = new Node(20), third = new Node(30);

        first.next = second;
        second.next = third;
        third.next = first;                             // <---- This link closes the circle by returning to the first node.

        Node current = first;

        do {                                            // <---- Stop when current returns to first; checking for null would never stop.
            System.out.println(current.value);

            current = current.next;
        } while (current != first);
    }
}
