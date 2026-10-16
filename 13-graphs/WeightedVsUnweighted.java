/*
    ==== WEIGHTED AND UNWEIGHTED GRAPHS ====

    An edge weight is a number such as travel time or cost. An unweighted graph treats each edge
    as one step; a weighted graph compares total weights instead.

    Complexity: BFS is O(V + E) for unweighted shortest paths; weighted shortest-path cost depends
    on the algorithm. V = vertices (nodes); E = edges (connections).
    Try: Add two routes: fewer edges with higher cost, and more edges with lower total cost.
*/

public class WeightedVsUnweighted {
    static class Edge {
        int to, cost;

        Edge(int t, int c) {
            to = t;
            cost = c;
        }
    }

    public static void main(String[] args) {
        Edge road = new Edge(2, 15);                    // <---- This edge leads to vertex 2 with a travel cost of 15.

        System.out.println("to=" + road.to + ", minutes=" + road.cost);
    }
}
