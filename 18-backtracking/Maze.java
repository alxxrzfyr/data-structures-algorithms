/*
    ==== FIND A PATH THROUGH A MAZE ====

    Backtracking explores one route at a time. Mark visited cells on that route, try neighboring
    cells, and undo the mark when the route reaches a dead end.

    Complexity: Worst-case time is exponential because different routes can retry cells. Recursion
    space is O(rows × cols).
    Try: Add a second valid path and modify the search to collect all routes.
*/

public class Maze {
    static int[][] maze = {{0, 0, 1}, {1, 0, 0}, {0, 0, 0}};
    static boolean[][] seen = new boolean[3][3];

    static boolean solve(int r, int c) {
        if (r < 0 || r >= maze.length || c < 0 || c >= maze[r].length
                || maze[r][c] == 1 || seen[r][c]) {
            return false;
        }

        if (r == maze.length - 1 && c == maze[r].length - 1) {
            return true;
        }

        seen[r][c] = true;                              // <---- Mark this cell so the current route cannot loop back into it.

        boolean found = solve(r + 1, c) || solve(r, c + 1) || solve(r - 1, c) || solve(r, c - 1);

        seen[r][c] = false;

        return found;
    }

    public static void main(String[] args) {
        System.out.println(solve(0, 0));
    }
}
