/*
    ==== UNION TWO SETS ====

    union merges two disjoint-set groups. Find each group's root, then make one root a child of
    the other. If the roots already match, the groups are already joined.

    Complexity: This simple union takes O(h) to find the roots, where h is their tree height.
    Try: Union the same two groups twice. Count a merge only when their roots differ.
*/

public class Union {
    static int find(int[] p, int x) {
        while (p[x] != x) {
            x = p[x];
        }

        return x;
    }

    static boolean union(int[] p, int a, int b) {
        int ra = find(p, a), rb = find(p, b);

        if (ra == rb) {
            return false;
        }

        p[ra] = rb;                                     // <---- Attach one root to the other so every item in both groups stays connected.

        return true;
    }

    public static void main(String[] args) {
        int[] p = {0, 1, 2, 3};

        System.out.println(union(p, 0, 1));
        System.out.println(union(p, 0, 1));
    }
}
