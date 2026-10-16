/*
    ==== KRUSKAL MINIMUM SPANNING TREE ====

    A minimum spanning tree connects all vertices of a connected, undirected graph with the lowest
    total edge weight. Kruskal tries edges from cheapest to most expensive, rejecting ones that
    make cycles.

    Complexity: Sorting takes O(E log E); find and union also follow parent links. Storage O(V +
    E). V = vertices (nodes); E = edges (connections).
    Try: Make the graph disconnected and note that a forest has fewer than V - 1 accepted edges.
*/

import java.util.*;

public class Kruskal {
    record Edge(int a, int b, int w) {}

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

            p[a] = b;

            return true;
        }
    }

    public static void main(String[] args) {
        List<Edge> e =
                new ArrayList<>(
                        List.of(
                                new Edge(0, 1, 4),
                                new Edge(0, 2, 1),
                                new Edge(1, 2, 2),
                                new Edge(1, 3, 5),
                                new Edge(2, 3, 3)));

        e.sort(Comparator.comparingInt(Edge::w));       // <---- Try lower-weight edges before more expensive ones.

        DSU d = new DSU(4);
        long total = 0;

        for (Edge x : e) {
            if (d.union(x.a(), x.b())) {                // <---- Join separate components; an edge inside one component would make a cycle.
                total += x.w();

                System.out.println(x.a() + "-" + x.b());
            }
        }

        System.out.println("weight=" + total);
    }
}
