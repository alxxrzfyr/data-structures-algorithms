/*
    ==== BINARY TREE NODE ====

    A binary tree node has at most two children. Unlike a binary search tree, a plain binary tree
    does not require smaller values on the left.

    Complexity: Visit all n nodes in O(n); storage O(n).
    Try: Change the node links to make an unbalanced tree.
*/

public class BinaryTree {
    static class Node {
        int value;
        Node left, right;

        Node(int v) {
            value = v;
        }
    }

    static void print(Node n) {
        if (n == null) {
            return;
        }

        System.out.println(n.value);

        print(n.left);                                  // <---- Visit both subtrees; their values do not have to be sorted.
        print(n.right);
    }

    public static void main(String[] args) {
        Node root = new Node(8);

        root.left = new Node(4);
        root.right = new Node(12);
        root.right.left = new Node(10);
        print(root);
    }
}
