/*
    ==== TREE HEIGHT AND BALANCE ====

    A node's height is the longest downward path to a leaf, measured in edges here. A tree is
    height-balanced when both child heights differ by at most 1 at every node.

    Complexity: Height O(n); this repeated balance check can be O(n²) on a skewed tree.
    Try: Return height and balance together to avoid recomputing child heights.
*/

public class Height {
    static class Node {
        Node left, right;

        Node(Node l, Node r) {
            left = l;
            right = r;
        }
    }

    static int height(Node n) {
        if (n == null) {                                            // <---- Using -1 for an empty subtree makes a leaf's height 0.
            return -1;
        }

        return 1 + Math.max(height(n.left), height(n.right));
    }

    static boolean balanced(Node n) {
        if (n == null) {
            return true;
        }

        return Math.abs(height(n.left) - height(n.right)) <= 1      // <---- Check this node's height difference and the balance of both subtrees.
                && balanced(n.left)
                && balanced(n.right);
    }

    public static void main(String[] args) {
        Node root = new Node(new Node(null, null), new Node(null, null));

        System.out.println(height(root) + " balanced=" + balanced(root));
    }
}
