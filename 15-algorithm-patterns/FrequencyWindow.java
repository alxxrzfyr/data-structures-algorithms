/*
    ==== LONGEST WINDOW WITHOUT REPEATS ====

    Checking every substring repeats work. Keep character frequencies for one ASCII window.
    After adding a repeated character, move the left edge until its count is one again. The
    window is valid after shrinking, and neither pointer moves backward.

    Complexity: Time O(n), extra space O(128), constant for ASCII. Empty input returns 0.
    Try: Explain why a single left-edge move is insufficient for the input abba.
*/

public class FrequencyWindow {
    static int longest(String text) {
        int[] count = new int[128];
        int left = 0, best = 0;

        for (int right = 0; right < text.length(); right++) {
            char c = text.charAt(right);

            if (c >= count.length) {
                throw new IllegalArgumentException("ASCII input required");
            }

            count[c]++;

            while (count[c] > 1) {
                count[text.charAt(left++)]--;          // <---- Shrink until adding this character no longer creates a duplicate.
            }

            best = Math.max(best, right - left + 1);
        }

        return best;
    }

    public static void main(String[] args) {
        System.out.println(longest("abba"));
    }
}
