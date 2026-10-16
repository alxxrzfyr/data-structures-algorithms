/*
    ==== FIND A SET REPRESENTATIVE ====

    A disjoint set tracks separate groups. Each group has a root called its representative. find
    follows parent references until it reaches that root.

    Complexity: This unoptimized find takes O(h), where h is the number of parent links to the
    root.
    Try: Print the root for several nodes after a few unions.
*/

public class Find {
    public static void main(String[] args) {
        int[] parent = {0, 0, 1, 3};
        int x = 2;

        while (parent[x] != x) {                        // <---- A node is the root when its parent is itself; otherwise keep following links.
            x = parent[x];
        }

        System.out.println(x);
    }
}
