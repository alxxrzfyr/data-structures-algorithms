/*
    ==== DISJOINT SET WITH PATH COMPRESSION ====

    Path compression speeds up find. After finding a group's root, point the visited nodes
    directly to it so their next search follows fewer links.

    Complexity: A find can follow many links at first; compression shortens later searches.
    Storage and setup take O(n).
    Try: Print parent links before and after find on a long chain.
*/

import java.util.Arrays;

public class PathCompression {
    static class DSU {
        int[] p;

        DSU(int n) {
            p = new int[n];

            for (int i = 0; i < n; i++) {
                p[i] = i;
            }
        }

        int find(int x) {
            if (p[x] != x) {
                p[x] = find(p[x]);                      // <---- Save the root as this node's direct parent to shorten future searches.
            }

            return p[x];
        }

        void union(int a, int b) {
            p[find(a)] = find(b);
        }
    }

    public static void main(String[] args) {
        DSU d = new DSU(5);

        d.union(0, 1);
        d.union(1, 2);
        d.union(2, 3);

        System.out.println(d.find(0));
        System.out.println(Arrays.toString(d.p));
    }
}
