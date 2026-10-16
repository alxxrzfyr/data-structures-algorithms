/*
    ==== DELETE FROM A BINARY SEARCH TREE ====

    BST deletion must preserve key order. A node with at most one child can be replaced by that
    child. With two children, use the smallest key in its right subtree.

    Complexity: Time O(h), where h is tree height; recursion space O(h).
    Try: Delete a leaf, a one-child node, then a two-child node.
*/

public class Deletion {
    static class Node {
        int v;
        Node l, r;

        Node(int v) {
            this.v = v;
        }
    }

    static Node add(Node n, int v) {
        if (n == null) {
            return new Node(v);
        }

        if (v < n.v) {
            n.l = add(n.l, v);
        } else if (v > n.v) {
            n.r = add(n.r, v);
        }

        return n;
    }

    static Node min(Node n) {
        while (n.l != null) {
            n = n.l;
        }

        return n;
    }

    static Node delete(Node n, int v) {
        if (n == null) {
            return null;
        }

        if (v < n.v) {
            n.l = delete(n.l, v);
        } else if (v > n.v) {
            n.r = delete(n.r, v);
        } else {
            if (n.l == null) {                          // <---- With no left child, the right child can replace this node.
                return n.r;
            }

            if (n.r == null) {
                return n.l;
            }

            Node next = min(n.r);                       // <---- The inorder successor is the next larger key: the right subtree's minimum.

            n.v = next.v;
            n.r = delete(n.r, next.v);
        }

        return n;
    }

    static void in(Node n) {
        if (n == null) {
            return;
        }

        in(n.l);

        System.out.print(n.v + " ");

        in(n.r);
    }

    public static void main(String[] args) {
        Node n = null;

        for (int v : new int[] {8, 4, 12, 10, 14, 6}) {
            n = add(n, v);
        }

        n = delete(n, 12);
        in(n);
    }
}
