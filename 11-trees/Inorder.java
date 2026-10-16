/*
    ==== INORDER TRAVERSAL ====

    Inorder traversal visits the left subtree, the node itself, and the right subtree. For a BST,
    that order produces sorted values.

    Complexity: Time O(n), call-stack space O(h); n is the node count and h is tree height.
    Try: Build an unbalanced tree and note that the traversal stays ordered.
*/

public class Inorder {
    static class Node {
        int value;
        Node left, right;

        Node(int v) {
            value = v;
        }
    }

    static void inorder(Node n) {
        if (n == null) {
            return;
        }

        inorder(n.left);                                // <---- Process left, node, then right to read a BST in increasing order.

        System.out.print(n.value + " ");

        inorder(n.right);
    }

    public static void main(String[] args) {
        Node r = new Node(8);

        r.left = new Node(4);
        r.right = new Node(12);
        r.left.left = new Node(2);
        r.left.right = new Node(6);
        inorder(r);
    }
}
