/*
    ==== GREEDY COIN CHANGE CAN FAIL ====

    A greedy algorithm chooses what looks best right now. Taking the largest fitting coin seems
    sensible, but some coin systems need a different choice to use fewer coins.

    Complexity: Time O(k + c), for k denominations and c coins used; extra space O(1). Greedy may
    use too many coins.
    Try: For coins 1, 3, 4 and amount 6, compare greedy with 3 + 3.
*/

public class CoinProblems {
    public static void main(String[] args) {
        int[] coins = {4, 3, 1};
        int amount = 6, count = 0;

        for (int c : coins) {
            while (amount >= c) {                       // <---- Keep taking this coin while it fits; the greedy choice may use too many coins.
                amount -= c;
                count++;
            }
        }

        System.out.println("greedy coin count=" + count);
        System.out.println("better: 3 + 3 uses 2 coins");
    }
}
