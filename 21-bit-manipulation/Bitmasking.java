/*
    ==== A BITMASK OF CHOSEN ITEMS ====

    A bitmask uses an integer's bits as yes/no flags. Bit i is 1 when item i is included. Counting
    through all masks generates every subset of a small input.

    Complexity: There are 2^n subsets. Printing n bit positions per subset takes O(n * 2^n) time.
    Try: For n = 3, list all masks and the selected indexes each mask represents.
*/

public class Bitmasking {
    public static void main(String[] args) {
        int n = 3;

        for (int mask = 0; mask < (1 << n); mask++) {       // <---- Each mask is one subset; a bit set to 1 includes its matching item.
            System.out.print("{");

            for (int bit = 0; bit < n; bit++) {
                if ((mask & (1 << bit)) != 0) {
                    System.out.print(bit + " ");
                }
            }

            System.out.println("}");
        }
    }
}
