/*
    ==== AVL INSERTION WITH ROTATIONS ====

    An AVL tree is a binary search tree that keeps its child-subtree heights close. After
    insertion, a rotation rearranges links to restore balance without breaking key order.

    Complexity: Search and insertion O(log n); each rotation O(1); tree space O(n).
    Try: Insert values in several orders and confirm the inorder output stays sorted and height
    stays small.
*/

public class AVLTree {
    static class Node {
        int key, height = 1;
        Node left, right;

        Node(int key) {
            this.key = key;
        }
    }

    static int height(Node n) {
        return n == null ? 0 : n.height;
    }

    static void update(Node n) {
        n.height = 1 + Math.max(height(n.left), height(n.right));
    }

    static int balance(Node n) {
        return n == null ? 0 : height(n.left) - height(n.right);
    }

    static Node right(Node root) {
        Node pivot = root.left;                         // <---- A right rotation moves the left child up without changing key order.

        root.left = pivot.right;
        pivot.right = root;
        update(root);
        update(pivot);

        return pivot;
    }

    static Node left(Node root) {
        Node pivot = root.right;                        // <---- A left rotation moves the right child up without changing key order.

        root.right = pivot.left;
        pivot.left = root;
        update(root);
        update(pivot);

        return pivot;
    }

    static Node insert(Node n, int key) {
        if (n == null) {
            return new Node(key);
        }

        if (key < n.key) {
            n.left = insert(n.left, key);
        } else if (key > n.key) {
            n.right = insert(n.right, key);
        } else {
            return n;
        }

        update(n);                                      // <---- Refresh this node's height, then check whether a rotation is needed.

        int b = balance(n);

        if (b > 1 && key < n.left.key) {
            return right(n);
        }

        if (b < -1 && key > n.right.key) {
            return left(n);
        }

        if (b > 1 && key > n.left.key) {
            n.left = left(n.left);
            return right(n);
        }

        if (b < -1 && key < n.right.key) {
            n.right = right(n.right);
            return left(n);
        }

        return n;
    }

    static void inorder(Node n) {
        if (n == null) {
            return;
        }

        inorder(n.left);

        System.out.print(n.key + " ");

        inorder(n.right);
    }

    public static void main(String[] args) {
        Node root = null;

        for (int key : new int[] {10, 20, 30, 40, 50, 25}) {
            root = insert(root, key);
        }

        inorder(root);

        System.out.println("\nheight=" + height(root));
    }
}
