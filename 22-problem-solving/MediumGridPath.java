/*
    ==== PRACTICE SHORTEST GRID ROUTE ====

    Problem: move in four directions from the top-left to the bottom-right cell using the fewest
    steps. Zero cells are open and one cells are blocked. Treat cells as vertices and use BFS.
    Example: the sample grid has distance 4. Return -1 if no route exists.

    Complexity: Time and space O(rows * columns). Input must be a nonempty rectangular grid
    containing only 0 and 1.
    Try: Save a parent cell and reconstruct one shortest route.
*/

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class MediumGridPath {
    static int distance(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            throw new IllegalArgumentException("nonempty grid required");
        }

        int rows = grid.length, columns = grid[0].length;

        for (int[] row : grid) {
            if (row.length != columns) {
                throw new IllegalArgumentException("rectangular grid required");
            }

            for (int cell : row) {
                if (cell != 0 && cell != 1) {
                    throw new IllegalArgumentException("cells must be zero or one");
                }
            }
        }

        if (grid[0][0] == 1 || grid[rows - 1][columns - 1] == 1) {
            return -1;
        }

        int[][] distance = new int[rows][columns];
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> queue = new ArrayDeque<>();

        for (int[] row : distance) {
            Arrays.fill(row, -1);
        }

        distance[0][0] = 0;
        queue.offer(new int[] {0, 0});

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();

            for (int[] direction : directions) {
                int r = cell[0] + direction[0], c = cell[1] + direction[1];

                if (r >= 0 && r < rows && c >= 0 && c < columns && grid[r][c] == 0 && distance[r][c] < 0) {
                    distance[r][c] = distance[cell[0]][cell[1]] + 1;   // <---- First discovery gives a shortest route because every move costs one step.
                    queue.offer(new int[] {r, c});
                }
            }
        }

        return distance[rows - 1][columns - 1];
    }

    public static void main(String[] args) {
        System.out.println(distance(new int[][] {{0, 1, 0}, {0, 0, 0}, {1, 1, 0}}));
    }
}
