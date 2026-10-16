/*
    ==== BINARY SEARCH TREE INSERT AND SEARCH ====

    A binary search tree, or BST, puts smaller keys in the left subtree and larger keys in the
    right subtree. Use this rule to insert or find a value.

    Complexity: Search/insert O(h); balanced O(log n), skewed O(n); recursive stack O(h). h = tree
    height; n = node count.
    Try: Insert sorted values and observe the tree become a chain.
*/

public class BinarySearchTree {
    static class Node {
        int value;
        Node left, right;

        Node(int v) {
            value = v;
        }
    }

    static Node insert(Node n, int v) {
        if (n == null) {                                // <---- A missing child is an empty position where the new node can go.
            return new Node(v);
        }

        if (v < n.value) {
            n.left = insert(n.left, v);
        } else if (v > n.value) {
            n.right = insert(n.right, v);
        }

        return n;
    }

    static boolean contains(Node n, int v) {
        while (n != null) {
            if (v == n.value) {
                return true;
            }

            n = v < n.value ? n.left : n.right;         // <---- Choose the only child subtree that could contain the target.
        }

        return false;
    }

    public static void main(String[] args) {
        Node root = null;

        for (int v : new int[] {8, 4, 12, 2, 6}) {
            root = insert(root, v);
        }

        System.out.println(contains(root, 6));
    }
}
