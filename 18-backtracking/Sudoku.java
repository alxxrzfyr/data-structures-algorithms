/*
    ==== SOLVE A 4 BY 4 SUDOKU ====

    Fill each empty cell with a digit allowed by its row, column, and box. Recursively try the
    remaining cells; undo a guess if it leads to a dead end.

    Complexity: Up to O(4^e) guesses in this 4 by 4 board, for e empty cells. Call-stack space
    O(e).
    Try: Remove more clues or adapt the box size and symbol range for a 9 by 9 puzzle.
*/

import java.util.Arrays;

public class Sudoku {
    static int[][] board = {{1, 0, 0, 4}, {0, 4, 1, 0}, {0, 1, 4, 0}, {4, 0, 0, 1}};

    static boolean safe(int r, int c, int v) {
        for (int i = 0; i < 4; i++) {
            if ((i != c && board[r][i] == v) || (i != r && board[i][c] == v)) {
                return false;
            }
        }

        int br = r / 2 * 2, bc = c / 2 * 2;             // <---- Integer division finds the top-left corner of this cell's 2 by 2 box.

        for (int i = br; i < br + 2; i++) {
            for (int j = bc; j < bc + 2; j++) {
                if ((i != r || j != c) && board[i][j] == v) {
                    return false;
                }
            }
        }

        return true;
    }

    static boolean solve() {
        for (int r = 0; r < 4; r++) {
            for (int c = 0; c < 4; c++) {
                int value = board[r][c];

                if (value < 0 || value > 4 || (value != 0 && !safe(r, c, value))) {
                    return false;
                }
            }
        }

        for (int r = 0; r < 4; r++) {
            for (int c = 0; c < 4; c++) {
                if (board[r][c] == 0) {
                    for (int v = 1; v <= 4; v++) {
                        if (safe(r, c, v)) {
                            board[r][c] = v;            // <---- Try this allowed digit, then check whether the rest can be solved.

                            if (solve()) {
                                return true;
                            }

                            board[r][c] = 0;            // <---- The guess failed, so reset the cell to empty before trying another digit.
                        }
                    }

                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(solve());

        for (int[] row : board) {
            System.out.println(Arrays.toString(row));
        }
    }
}
