/*
    ==== UPPER LOWER AND TIGHT BOUNDS ====

    Big O gives an upper bound, Omega gives a lower bound, and Theta gives both. A complete scan
    always visits n elements, so its work is Theta(n). A loose O(n squared) bound is also true,
    but says less. These bounds are separate from best, average, and worst input cases.

    Complexity: A full scan has Theta(n) time and O(1) extra space.
    Try: Explain why n + 5 and 3 * n both have a tight Theta(n) growth bound.
*/

public class GrowthBounds {
    public static void main(String[] args) {
        for (int n : new int[] {4, 8, 16}) {
            int[] values = new int[n];
            int visits = 0;

            for (int value : values) {
                visits++;                              // <---- Changing element values cannot change the number of full-scan visits.
            }

            System.out.println("n=" + n + ", visits=" + visits);
        }
    }
}
