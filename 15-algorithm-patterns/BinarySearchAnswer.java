/*
    ==== BINARY SEARCH ON A FEASIBLE ANSWER ====

    Ship packages in their given order within a day limit. A capacity that works remains valid
    when increased, so feasibility changes from false to true. Search for the first true
    capacity between the largest package and the total weight instead of trying every capacity.

    Complexity: Time O(n log S), extra space O(1), where S is the total positive weight. Weights
    must be positive and days at least one; empty input returns 0.
    Try: Explain why sorting the packages would change the problem rather than optimize this
    solution.
*/

public class BinarySearchAnswer {
    static boolean fits(int[] weights, int days, long capacity) {
        int used = 1;
        long load = 0;

        for (int weight : weights) {
            if (weight > capacity) {
                return false;
            }

            if (load + weight > capacity) {
                used++;
                load = 0;
            }

            load += weight;
        }

        return used <= days;
    }

    static long minimum(int[] weights, int days) {
        if (days < 1) {
            throw new IllegalArgumentException("days must be positive");
        }

        long low = 0, high = 0;

        for (int weight : weights) {
            if (weight <= 0) {
                throw new IllegalArgumentException("weights must be positive");
            }

            low = Math.max(low, weight);
            high += weight;
        }

        while (low < high) {
            long middle = low + (high - low) / 2;

            if (fits(weights, days, middle)) {
                high = middle;                         // <---- This capacity works, but a smaller working capacity may still exist.
            } else {
                low = middle + 1;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        System.out.println(minimum(new int[] {1, 2, 3, 4, 5}, 3));
    }
}
