/*
    ==== INSERT A WORD INTO A TRIE ====

    A trie stores words along character paths. Words with the same prefix, or starting letters,
    share nodes. Mark the last node to show that a full word ends there.

    Complexity: Time O(L) for a word of length L; new space O(L) in the worst case.
    Try: Insert a second word with the same prefix and count how many nodes are shared.
*/

import java.util.HashMap;
import java.util.Map;

public class Insertion {
    static class Node {
        Map<Character, Node> next = new HashMap<>();
        boolean terminal;
    }

    static void insert(Node root, String word) {
        Node n = root;

        for (char c : word.toCharArray()) {
            n = n.next.computeIfAbsent(c, k -> new Node());     // <---- Reuse the character's child node, or create it if it is missing.
        }

        n.terminal = true;                                      // <---- This node ends a word; earlier nodes may only be prefixes.
    }

    public static void main(String[] args) {
        Node root = new Node();

        insert(root, "tree");
        insert(root, "trie");

        System.out.println(root.next.get('t').next.get('r').next.size());
    }
}
