/*
    ==== PREORDER TRAVERSAL ====

    Preorder traversal visits a node before its children. Then it visits the left subtree and
    finally the right subtree.

    Complexity: Time O(n), call-stack space O(h) for tree height h. h = tree height; n = node
    count.
    Try: Compare the output with inorder and postorder for the same tree.
*/

public class Preorder {
    static class Node {
        int value;
        Node left, right;

        Node(int v) {
            value = v;
        }
    }

    static void preorder(Node n) {
        if (n == null) {
            return;
        }

        System.out.print(n.value + " ");                // <---- Read this node before making recursive calls for its children.

        preorder(n.left);
        preorder(n.right);
    }

    public static void main(String[] args) {
        Node r = new Node(8);

        r.left = new Node(4);
        r.right = new Node(12);
        r.left.left = new Node(2);
        r.left.right = new Node(6);
        preorder(r);
    }
}
