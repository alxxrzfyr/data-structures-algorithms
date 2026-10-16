/*
    ==== PALINDROMES WITH TWO POINTERS ====

    A palindrome reads the same forward and backward. Compare the outer characters and move
    inward. If one pair differs, the whole string cannot be a palindrome. This method compares
    UTF-16 code units and is intended for ASCII examples.

    Complexity: Time O(n), extra space O(1). Empty and single-character strings are palindromes.
    Try: Ignore uppercase versus lowercase using an explicitly chosen normalization rule.
*/

public class Palindrome {
    static boolean isPalindrome(String text) {
        int left = 0, right = text.length() - 1;

        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;                          // <---- One mismatched pair disproves the palindrome property.
            }

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("level"));
        System.out.println(isPalindrome("java"));
    }
}
