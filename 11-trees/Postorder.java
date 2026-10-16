/*
    ==== POSTORDER TRAVERSAL ====

    Postorder visits the left subtree, then the right subtree, then the current node. Children
    are processed before their parent, which fits tasks such as computing a directory total or
    deleting a whole tree.

    Complexity: Time O(n), call-stack space O(h), where h is tree height.
    Try: Use postorder to calculate a subtree sum before returning it to the parent.
*/

public class Postorder {
    static class Node {
        int value;
        Node left, right;

        Node(int value) {
            this.value = value;
        }
    }

    static void visit(Node node) {
        if (node == null) {
            return;
        }

        visit(node.left);
        visit(node.right);
        System.out.print(node.value + " ");            // <---- Process the parent only after both child subtrees finish.
    }

    public static void main(String[] args) {
        Node root = new Node(2);

        root.left = new Node(1);
        root.right = new Node(3);

        visit(root);
    }
}
