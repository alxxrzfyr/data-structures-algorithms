/*
    ==== N-QUEENS FOR FOUR QUEENS ====

    Place one queen in each row. A legal choice cannot share a column or diagonal with an earlier
    queen. Backtrack when no legal column remains.

    Complexity: Worst-case time grows exponentially as board size n increases. Column, diagonal,
    and call-stack storage are O(n).
    Try: Print the board for each solution instead of only counting them.
*/

public class NQueens {
    static int n = 4, count = 0;
    static boolean[] col = new boolean[n], d1 = new boolean[2 * n], d2 = new boolean[2 * n];
    static int[] rowAt = new int[n];

    static void place(int r) {
        if (r == n) {
            count++;
            return;
        }

        for (int c = 0; c < n; c++) {
            int a = r - c + n, b = r + c;               // <---- r - c and r + c label the two diagonals passing through this square.

            if (col[c] || d1[a] || d2[b]) {
                continue;
            }

            col[c] = d1[a] = d2[b] = true;
            rowAt[r] = c;
            place(r + 1);
            col[c] = d1[a] = d2[b] = false;             // <---- Backtrack: release this column and its diagonals for another choice.
        }
    }

    public static void main(String[] args) {
        place(0);

        System.out.println(count);
    }
}
