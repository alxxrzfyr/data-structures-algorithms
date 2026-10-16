/*
    ==== CHOOSE COMBINATIONS ====

    A combination chooses k different values without caring about their order. Always choose the
    next value from later positions to avoid repeated combinations.

    Complexity: Time O(C(n, k) * k) to print all choices; C(n, k) is the number of ways to choose
    k from n. Stack O(k).
    Try: Stop a branch early when too few values remain to fill its k positions; this is pruning.
*/

import java.util.*;

public class Combinations {
    static void choose(int n, int k, int next, List<Integer> path) {
        if (path.size() == k) {
            System.out.println(path);
            return;
        }

        for (int v = next; v <= n; v++) {
            path.add(v);
            choose(n, k, v + 1, path);                  // <---- Choose only later values next, so 1,2 and 2,1 are not both generated.
            path.remove(path.size() - 1);               // <---- Backtrack: remove this choice before trying another value.
        }
    }

    public static void main(String[] args) {
        choose(4, 2, 1, new ArrayList<>());
    }
}
