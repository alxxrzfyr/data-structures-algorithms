/*
    ==== PRACTICE AT MOST K DISTINCT CHARACTERS ====

    Problem: find the longest substring with at most k distinct ASCII characters. Example: eceba
    with k = 2 returns 3. Track frequencies and the number of positive counters. Shrink only
    while the distinct count exceeds k; repeated characters are allowed.

    Complexity: Time O(n), extra space O(128). Require k >= 0; k = 0 returns 0.
    Try: Return the actual substring and choose the earliest start when lengths tie.
*/

public class MediumDistinctWindow {
    static int longest(String text, int k) {
        if (k < 0) {
            throw new IllegalArgumentException("negative k");
        }

        int[] count = new int[128];
        int left = 0, distinct = 0, best = 0;

        for (int right = 0; right < text.length(); right++) {
            char c = text.charAt(right);

            if (c >= count.length) {
                throw new IllegalArgumentException("ASCII input required");
            }

            if (count[c]++ == 0) {
                distinct++;
            }

            while (distinct > k) {
                if (--count[text.charAt(left++)] == 0) {
                    distinct--;                        // <---- A character leaves the distinct set only after its final occurrence leaves.
                }
            }

            best = Math.max(best, right - left + 1);
        }

        return best;
    }

    public static void main(String[] args) {
        System.out.println(longest("eceba", 2));
    }
}
