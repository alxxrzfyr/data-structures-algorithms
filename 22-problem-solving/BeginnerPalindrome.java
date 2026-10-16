/*
    ==== PRACTICE FILTERED PALINDROME ====

    Problem: ignore ASCII punctuation and letter case when checking a palindrome. Digits still
    count. Example: A man, a plan, a canal: Panama returns true. Two pointers skip ignored
    characters without creating a filtered copy. Inputs must be ASCII.

    Complexity: Time O(n), extra space O(1). An input containing no letters or digits is a
    palindrome.
    Try: Explain how this differs from comparing every original character directly.
*/

public class BeginnerPalindrome {
    static boolean check(String text) {
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) >= 128) {
                throw new IllegalArgumentException("ASCII input required");
            }
        }

        int left = 0, right = text.length() - 1;

        while (left < right) {
            char a = text.charAt(left), b = text.charAt(right);

            if (!Character.isLetterOrDigit(a)) {
                left++;
            } else if (!Character.isLetterOrDigit(b)) {
                right--;
            } else {
                if (Character.toLowerCase(a) != Character.toLowerCase(b)) {
                    return false;
                }

                left++;
                right--;                               // <---- Advance both ends only after comparing two meaningful characters.
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(check("A man, a plan, a canal: Panama"));
    }
}
