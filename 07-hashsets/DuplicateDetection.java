/*
    ==== DETECT A DUPLICATE ====

    Use a set to remember values you have already seen. If add returns false, the value is a
    duplicate.

    Complexity: Time O(n) expected, extra space O(n).
    Try: Return the repeated value rather than only true or false.
*/

import java.util.HashSet;
import java.util.Set;

public class DuplicateDetection {
    public static void main(String[] args) {
        int[] values = {4, 2, 7, 2};
        Set<Integer> seen = new HashSet<>();

        for (int value : values) {
            if (!seen.add(value)) {                     // <---- false means the set already contains this value.
                System.out.println("duplicate: " + value);
                return;
            }
        }

        System.out.println("no duplicate");
    }
}
