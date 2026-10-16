/*
    ==== COUNTING PATHS THROUGH A GRID ====

    Move only right or down from the top-left cell. Each cell can be reached from the cell above
    or to its left, so add those two counts. Fill the table in an order that makes both
    dependencies available. This introduces a two-coordinate DP state before knapsack.

    Complexity: Time and space O(rows * columns). Positive dimensions are required. Large grids
    can overflow long; this example reports overflow.
    Try: Add blocked cells and make their path counts zero.
*/

public class GridPaths {
    static long count(int rows, int columns) {
        if (rows < 1 || columns < 1) {
            throw new IllegalArgumentException("positive dimensions required");
        }

        long[][] ways = new long[rows][columns];

        ways[0][0] = 1;

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                if (row > 0) {
                    ways[row][column] = Math.addExact(ways[row][column], ways[row - 1][column]);
                }

                if (column > 0) {
                    ways[row][column] = Math.addExact(ways[row][column], ways[row][column - 1]);   // <---- Paths from the left and above are separate possibilities.
                }
            }
        }

        return ways[rows - 1][columns - 1];
    }

    public static void main(String[] args) {
        System.out.println(count(3, 4));
    }
}
