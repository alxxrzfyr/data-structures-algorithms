/*
    ==== DEPTH OF A NODE ====

    A node's depth is the number of edges from the root to that node. The root has depth 0; each
    step to a child adds 1.

    Complexity: Time O(n) to search a general binary tree; call-stack space O(h), where h is tree
    height.
    Try: What depth should be returned when the value is absent?
*/

public class Depth {
    static class Node {
        int v;
        Node l, r;

        Node(int v) {
            this.v = v;
        }
    }

    static int depth(Node n, int target, int d) {
        if (n == null) {                                // <---- This path ended without a match, so return -1 to mean not found.
            return -1;
        }

        if (n.v == target) {
            return d;
        }

        int left = depth(n.l, target, d + 1);           // <---- Try the left subtree first, then try the right if it returns -1.

        return left != -1 ? left : depth(n.r, target, d + 1);
    }

    public static void main(String[] args) {
        Node r = new Node(8);

        r.l = new Node(4);
        r.l.r = new Node(6);

        System.out.println(depth(r, 6, 0));
    }
}
