/*
    ==== TWO-DIMENSIONAL ARRAYS ====

    A two-dimensional array is an array of row arrays. Each row can have its own length, so rows
    do not have to form a rectangle.

    Complexity: Read a cell is O(1); visiting every cell is O(total cells).
    Try: Add an empty row and another row with four values, then predict the output.
*/

public class MultidimensionalArrays {
    public static void main(String[] args) {
        int[][] grid = {{1, 2, 3}, {4, 5}, {6}};

        for (int[] row : grid) {                        // <---- The outer loop selects one row array at a time.
            for (int value : row) {                     // <---- The inner loop reads each value in the selected row.
                System.out.print(value + " ");          // <---- print keeps the row's values on one output line.
            }

            System.out.println();                       // <---- println ends this row's output before the next row starts.
        }
    }
}
