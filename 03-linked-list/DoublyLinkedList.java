/*
    ==== DOUBLY LINKED LIST ====

    A doubly linked node has next and previous references. These links allow traversal in either
    direction.

    Complexity: Changing links at a known node is O(1); finding that node can take O(n). Node
    storage is O(n).
    Try: Add a node at the front and update both directions.
*/

public class DoublyLinkedList {
    static class Node {
        int value;
        Node next, previous;

        Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Node first = new Node(10), second = new Node(20), third = new Node(30);

        first.next = second;                                                // <---- Set next and previous links so neighboring nodes can reach each other.
        second.previous = first;
        second.next = third;
        third.previous = second;

        for (Node node = third; node != null; node = node.previous) {       // <---- Start at the last node and follow previous links backward.
            System.out.println(node.value);
        }
    }
}
