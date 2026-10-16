/*
    ==== RECOVERING KNAPSACK CHOICES ====

    After finding the best knapsack value, walk backward through its table. If the current row
    differs from the previous row at this capacity, the current item was selected. Subtract its
    weight and continue. When values tie, this method skips the current item.

    Complexity: Time and space O(n * C); reconstruction O(n). Positive weights, nonnegative
    capacity, and matching array lengths are required. int item values accumulate in long.
    Try: Return both the selected indexes and the total value, then verify the capacity limit.
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KnapsackReconstruction {
    static List<Integer> choose(int[] weights, int[] values, int capacity) {
        if (weights.length != values.length || capacity < 0) {
            throw new IllegalArgumentException("invalid items or capacity");
        }

        for (int weight : weights) {
            if (weight <= 0) {
                throw new IllegalArgumentException("weights must be positive");
            }
        }

        long[][] best = new long[weights.length + 1][capacity + 1];

        for (int i = 1; i <= weights.length; i++) {
            for (int c = 0; c <= capacity; c++) {
                best[i][c] = best[i - 1][c];

                if (weights[i - 1] <= c) {
                    best[i][c] = Math.max(best[i][c], values[i - 1] + best[i - 1][c - weights[i - 1]]);
                }
            }
        }

        List<Integer> selected = new ArrayList<>();
        int remaining = capacity;

        for (int i = weights.length; i > 0; i--) {
            if (best[i][remaining] != best[i - 1][remaining]) {
                selected.add(i - 1);
                remaining -= weights[i - 1];           // <---- Move to the smaller subproblem that supplied this selected-item choice.
            }
        }

        Collections.reverse(selected);

        return selected;
    }

    public static void main(String[] args) {
        System.out.println(choose(new int[] {2, 3, 4}, new int[] {4, 5, 7}, 5));
    }
}
