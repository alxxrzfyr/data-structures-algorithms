/*
    ==== ANALYZING A RECURSION TREE ====

    A recurrence describes work using smaller calls. Splitting a range in half and doing work
    proportional to its size gives T(n) = 2T(n/2) + Theta(n) for powers of two. Each level has n
    units of work, and there are log2(n) levels, so total work is Theta(n log n).

    Complexity: Time Theta(n log n) for n at least 2; call-stack space O(log n). Empty and one-
    item ranges do no counted work.
    Try: Compare this recurrence with T(n) = T(n - 1) + Theta(1).
*/

public class RecursionTree {
    static long work(int size) {
        if (size <= 1) {
            return 0;
        }

        int left = size / 2;
        long ownWork = 0;

        for (int i = 0; i < size; i++) {
            ownWork++;                                 // <---- Across one recursion level, these loops process the original total size.
        }

        return ownWork + work(left) + work(size - left);
    }

    public static void main(String[] args) {
        for (int n : new int[] {2, 4, 8, 16}) {
            System.out.println(n + " -> " + work(n));
        }
    }
}
