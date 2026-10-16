/*
    ==== OPTIMAL SUBSTRUCTURE ====

    Optimal substructure means building a best answer from best answers to smaller problems. In
    a grid, move only right or down and pay each visited cell's cost. A cheapest route to a cell
    must use a cheapest route to the cell above or to its left; replacing a more expensive
    prefix would improve the whole route.

    Complexity: Time and space O(rows * columns). Require a nonempty rectangular grid of
    nonnegative int costs; totals use long.
    Try: Trace both possible previous cells before choosing the cheaper prefix.
*/

public class OptimalSubstructure {
    static long cost(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            throw new IllegalArgumentException("nonempty grid required");
        }

        int rows = grid.length, columns = grid[0].length;
        long[][] best = new long[rows][columns];

        for (int row = 0; row < rows; row++) {
            if (grid[row].length != columns) {
                throw new IllegalArgumentException("rectangular grid required");
            }

            for (int column = 0; column < columns; column++) {
                if (grid[row][column] < 0) {
                    throw new IllegalArgumentException("nonnegative costs required");
                }

                if (row == 0 && column == 0) {
                    best[row][column] = grid[row][column];
                } else {
                    long above = row > 0 ? best[row - 1][column] : Long.MAX_VALUE;
                    long left = column > 0 ? best[row][column - 1] : Long.MAX_VALUE;

                    best[row][column] = Math.min(above, left) + grid[row][column];   // <---- Extend the cheapest valid prefix by this cell's cost.
                }
            }
        }

        return best[rows - 1][columns - 1];
    }

    public static void main(String[] args) {
        System.out.println(cost(new int[][] {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
    }
}
