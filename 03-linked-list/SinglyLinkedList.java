/*
    ==== SINGLY LINKED LIST ====

    Each node stores a value and a next reference. head points to the first node; tail points to
    the last, making it easy to append a new node.

    Complexity: Add at head O(1); append with a tail O(1); search O(n); space O(n).
    Try: Add a remove-first operation and handle the empty list.
*/

public class SinglyLinkedList {
    static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    static class List {
        Node head, tail;

        void addLast(int value) {
            Node node = new Node(value);

            if (head == null) {                         // <---- For the first insertion, head and tail must refer to the same node.
                head = node;
            } else {
                tail.next = node;
            }

            tail = node;                                // <---- Keep tail on the last node so the next append needs no search.
        }

        void print() {
            for (Node node = head; node != null; node = node.next) {
                System.out.print(node.value + (node.next == null ? "\n" : " -> "));
            }
        }
    }

    public static void main(String[] args) {
        List list = new List();

        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.print();
    }
}
