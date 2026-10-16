/*
    ==== DISJOINT SETS BEFORE KRUSKAL ====

    A disjoint set groups vertices that are already connected. Each root represents one
    component. Joining two different roots merges components; joining equal roots would add a
    cycle. Learn this basic contract before Kruskal, then study compression and rank in the
    dedicated lesson.

    Complexity: This simple find/union can take O(V) per operation; storage O(V). Vertex indexes
    must be valid.
    Try: Count successful unions and explain why each one reduces the component count by one.
*/

public class DisjointSetBasics {
    static class Groups {
        int[] parent;

        Groups(int size) {
            parent = new int[size];

            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
        }

        int find(int vertex) {
            while (parent[vertex] != vertex) {
                vertex = parent[vertex];
            }

            return vertex;
        }

        boolean union(int first, int second) {
            int a = find(first), b = find(second);

            if (a == b) {
                return false;
            }

            parent[a] = b;                             // <---- Two previously separate components now share one root.

            return true;
        }
    }

    public static void main(String[] args) {
        Groups groups = new Groups(3);

        System.out.println(groups.union(0, 1));
        System.out.println(groups.union(1, 2));
        System.out.println(groups.union(0, 2));
    }
}
