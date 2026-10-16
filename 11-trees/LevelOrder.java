/*
    ==== LEVEL ORDER TRAVERSAL ====

    Level-order traversal visits nodes one level at a time. A queue keeps parents ahead of their
    children.

    Complexity: Time O(n), extra space O(w), where w is maximum tree width.
    Try: Print a newline after each level using the queue size at the start of that level.
*/

import java.util.ArrayDeque;
import java.util.Queue;

public class LevelOrder {
    static class Node {
        int value;
        Node left, right;

        Node(int v) {
            value = v;
        }
    }

    public static void main(String[] args) {
        Node r = new Node(8);

        r.left = new Node(4);
        r.right = new Node(12);

        Queue<Node> q = new ArrayDeque<>();

        q.offer(r);

        while (!q.isEmpty()) {                          // <---- The FIFO queue visits earlier parents before their newly added children.
            Node n = q.poll();

            System.out.print(n.value + " ");

            if (n.left != null) {
                q.offer(n.left);
            }

            if (n.right != null) {
                q.offer(n.right);
            }
        }
    }
}
