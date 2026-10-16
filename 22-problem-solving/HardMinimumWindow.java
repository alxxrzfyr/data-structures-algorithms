/*
    ==== PRACTICE MINIMUM COVERING SUBSTRING ====

    Problem: find the shortest substring containing every target character with its required
    frequency. Example: ADOBECODEBANC and ABC return BANC. Expand until all required occurrences
    are present, then shrink while the window stays valid. Inputs must be ASCII; return an empty
    string for an empty target or no solution.

    Complexity: Time O(n + m), extra space O(128), plus the returned substring. Keep the
    earliest answer when minimum lengths tie.
    Try: Use a target with repeated characters, such as AABC, and explain why a set is
    insufficient.
*/

public class HardMinimumWindow {
    static String find(String text, String target) {
        int[] need = new int[128];

        for (String input : new String[] {text, target}) {
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) >= need.length) {
                    throw new IllegalArgumentException("ASCII input required");
                }
            }
        }

        if (target.isEmpty()) {
            return "";
        }

        for (int i = 0; i < target.length(); i++) {
            need[target.charAt(i)]++;
        }

        int missing = target.length(), left = 0, bestStart = 0, bestLength = Integer.MAX_VALUE;

        for (int right = 0; right < text.length(); right++) {
            if (need[text.charAt(right)]-- > 0) {      // <---- A positive need means this occurrence fills a missing requirement.
                missing--;
            }

            while (missing == 0) {
                if (right - left + 1 < bestLength) {
                    bestStart = left;
                    bestLength = right - left + 1;
                }

                if (++need[text.charAt(left++)] > 0) {
                    missing++;                         // <---- Removing a required occurrence makes this window incomplete again.
                }
            }
        }

        return bestLength == Integer.MAX_VALUE ? "" : text.substring(bestStart, bestStart + bestLength);
    }

    public static void main(String[] args) {
        System.out.println(find("ADOBECODEBANC", "ABC"));
    }
}
