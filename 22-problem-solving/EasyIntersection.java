/*
    ==== PRACTICE SORTED MULTISET INTERSECTION ====

    Problem: intersect two sorted int arrays, retaining each value the smaller number of times
    it occurs in the inputs. Example: [1, 2, 2, 4] and [2, 2, 3] return [2, 2]. Two pointers
    avoid hashing and advance the side with the smaller current value.

    Complexity: Time O(n + m), extra storage O(min(n, m)) for the result buffer. Inputs must be
    sorted.
    Try: Change the result to contain each common value only once.
*/

import java.util.Arrays;

public class EasyIntersection {
    static int[] find(int[] first, int[] second) {
        int[] result = new int[Math.min(first.length, second.length)];
        int i = 0, j = 0, size = 0;

        while (i < first.length && j < second.length) {
            if (first[i] < second[j]) {
                i++;
            } else if (first[i] > second[j]) {
                j++;
            } else {
                result[size++] = first[i];             // <---- Consume one occurrence from each input to preserve multiplicity.
                i++;
                j++;
            }
        }

        return Arrays.copyOf(result, size);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(find(new int[] {1, 2, 2, 4}, new int[] {2, 2, 3})));
    }
}
