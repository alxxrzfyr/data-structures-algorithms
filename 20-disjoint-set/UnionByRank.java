/*
    ==== UNION BY RANK ====

    Union by rank keeps disjoint-set trees short. Rank is an estimate of a root's tree height.
    Attach the lower-rank root below the higher-rank root; if ranks match, increase only the
    chosen root's rank by 1.

    Complexity: With path compression, operations are nearly constant time on average over many
    calls. Storage O(n).
    Try: Keep a component count and decrease it only when two different roots merge.
*/

public class UnionByRank {
    static class DSU {
        int[] p, rank;

        DSU(int n) {
            p = new int[n];
            rank = new int[n];

            for (int i = 0; i < n; i++) {
                p[i] = i;
            }
        }

        int find(int x) {
            if (p[x] != x) {
                p[x] = find(p[x]);
            }

            return p[x];
        }

        boolean union(int a, int b) {
            a = find(a);
            b = find(b);

            if (a == b) {
                return false;
            }

            if (rank[a] < rank[b]) {                    // <---- Put the lower-rank tree under the higher-rank root.
                p[a] = b;
            } else if (rank[b] < rank[a]) {
                p[b] = a;
            } else {
                p[b] = a;
                rank[a]++;                              // <---- Equal ranks were merged, so increase the chosen root's rank by 1.
            }

            return true;
        }
    }

    public static void main(String[] args) {
        DSU d = new DSU(4);

        d.union(0, 1);
        d.union(2, 3);
        d.union(1, 2);

        System.out.println(d.find(0) == d.find(3));
    }
}
