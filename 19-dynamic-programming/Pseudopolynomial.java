/*
    ==== CAPACITY IS NOT INPUT LENGTH ====

    Knapsack runs in O(n * C), where C is the numeric capacity. Storing C needs only about
    log2(C) bits. Doubling capacity adds roughly one bit but doubles the number of table
    columns. This is pseudopolynomial time: polynomial in the numeric value, not necessarily in
    the encoded input length.

    Complexity: Each demonstration uses O(n * C) time and space. Capacities are deliberately
    small.
    Try: Compare capacities 1000 and 1000000 before deciding whether a capacity table is
    practical.
*/

public class Pseudopolynomial {
    public static void main(String[] args) {
        int[] weights = {2, 3, 4}, values = {4, 5, 7};

        for (int capacity : new int[] {8, 16, 32}) {
            int[][] best = new int[weights.length + 1][capacity + 1];
            int states = 0;

            for (int i = 1; i <= weights.length; i++) {
                for (int c = 0; c <= capacity; c++) {
                    best[i][c] = best[i - 1][c];

                    if (weights[i - 1] <= c) {
                        best[i][c] = Math.max(best[i][c], values[i - 1] + best[i - 1][c - weights[i - 1]]);
                    }

                    states++;                          // <---- Count states instead of trusting a runtime label without considering capacity.
                }
            }

            int bits = Integer.toBinaryString(capacity).length();

            System.out.println("capacity=" + capacity + ", bits=" + bits + ", states=" + states);
        }
    }
}
