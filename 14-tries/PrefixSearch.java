/*
    ==== TRIE PREFIX SEARCH ====

    A trie follows one node per character. Prefix search asks whether that path exists. Exact
    search also checks a terminal flag, which marks the end of a stored word.

    Complexity: Insert/search/prefix lookup take O(L) time for L characters; storage depends on
    shared prefixes.
    Try: Check that car is a prefix of cart but not a stored word until marked terminal.
*/

import java.util.HashMap;
import java.util.Map;

public class PrefixSearch {
    static class Node {
        Map<Character, Node> children = new HashMap<>();
        boolean word;
    }

    static class Trie {
        Node root = new Node();

        void add(String s) {
            Node n = root;

            for (char c : s.toCharArray()) {
                n = n.children.computeIfAbsent(c, k -> new Node());     // <---- Reuse existing nodes when words start with the same characters.
            }

            n.word = true;
        }

        boolean hasPrefix(String s) {
            Node n = root;

            for (char c : s.toCharArray()) {
                n = n.children.get(c);

                if (n == null) {
                    return false;
                }
            }

            return true;
        }

        boolean hasWord(String s) {
            Node n = root;

            for (char c : s.toCharArray()) {
                n = n.children.get(c);

                if (n == null) {
                    return false;
                }
            }

            return n.word;                                              // <---- A matching path is not enough for exact search; a word must end here.
        }
    }

    public static void main(String[] args) {
        Trie t = new Trie();

        t.add("cart");

        System.out.println(t.hasPrefix("car") + " " + t.hasWord("car"));
    }
}
