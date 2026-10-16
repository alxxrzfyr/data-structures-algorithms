/*
    ==== INORDER WITH AN EXPLICIT STACK ====

    Recursive traversal remembers unfinished ancestors on the call stack. An iterative traversal
    stores those nodes in a Deque instead. Push the left path, visit the next ancestor, then
    explore its right subtree.

    Complexity: Time O(n), extra space O(h). The explicit stack avoids recursive calls but still
    stores the path.
    Try: Trace which ancestors remain on the stack after each visit.
*/

import java.util.ArrayDeque;
import java.util.Deque;

public class IterativeTraversal {
    static class Node {
        int value;
        Node left, right;

        Node(int value) {
            this.value = value;
        }
    }

    static void inorder(Node current) {
        Deque<Node> stack = new ArrayDeque<>();

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();                     // <---- Its left subtree is complete, so this node is next in inorder.
            System.out.print(current.value + " ");
            current = current.right;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(2);

        root.left = new Node(1);
        root.right = new Node(3);

        inorder(root);
    }
}
