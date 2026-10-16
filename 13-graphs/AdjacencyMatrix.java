/*
    ==== ADJACENCY MATRIX ====

    An adjacency matrix uses a row and column for each vertex. A cell records whether an edge
    connects those two vertices.

    Complexity: Space O(V²); test whether an edge exists in O(1); visit neighbors O(V). V =
    vertices (nodes); E = edges (connections).
    Try: Compare memory use for a graph with 1,000 vertices and only 1,000 edges.
*/

public class AdjacencyMatrix {
    public static void main(String[] args) {
        int[][] edge = new int[4][4];

        edge[0][1] = 1;
        edge[1][0] = 1;                                 // <---- If 0 connects to 1, an undirected graph also connects 1 to 0.
        edge[1][2] = 1;
        edge[2][1] = 1;

        for (int[] row : edge) {
            for (int v : row) {
                System.out.print(v + " ");
            }

            System.out.println();
        }
    }
}
