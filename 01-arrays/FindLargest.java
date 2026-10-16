/*
    ==== FIND THE LARGEST ====

    Keep the largest value found so far. Compare each array item with it and replace it when a
    larger value appears.

    Complexity: Time O(n), extra space O(1).
    Try: Use only negative values, then decide how to handle an empty input array.
*/

public class FindLargest {
    public static void main(String[] args) {
        int[] values = {-4, -2, -9, -1};
        int largest = values[0];                        // <---- Start with the first item, not 0, so negative-only input works too.

        for (int value : values) {
            if (value > largest) {
                largest = value;
            }
        }

        System.out.println(largest);
    }
}
