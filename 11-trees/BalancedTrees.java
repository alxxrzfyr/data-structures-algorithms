/*
    ==== WHY BALANCE MATTERS ====

    Tree height affects search time. A balanced BST keeps paths short; inserting sorted keys into
    an ordinary BST can create one long chain.

    Complexity: Search is O(log n) when balanced, but O(n) in a chain; n is the node count.
    Try: Compare heights after inserting 1 through 7 in order versus 4, 2, 6, 1, 3, 5, 7.
*/

public class BalancedTrees {
    static class Node {
        int v;
        Node l, r;

        Node(int v) {
            this.v = v;
        }
    }

    static Node insert(Node n, int v) {
        if (n == null) {
            return new Node(v);
        }

        if (v < n.v) {
            n.l = insert(n.l, v);
        } else {
            n.r = insert(n.r, v);
        }

        return n;
    }

    static int height(Node n) {
        return n == null ? 0 : 1 + Math.max(height(n.l), height(n.r));
    }

    public static void main(String[] args) {
        Node root = null;

        for (int v = 1; v <= 7; v++) {                  // <---- Every new key is larger, so each insertion follows the right side.
            root = insert(root, v);
        }

        System.out.println("skewed height=" + height(root));
    }
}
