/*
    ==== CODE UNITS AND CODE POINTS ====

    Java char stores one UTF-16 code unit. Some Unicode code points need two char values, called
    a surrogate pair. length counts code units; codePointCount counts code points. A visible
    symbol can still contain several code points, so this is not full grapheme handling.

    Complexity: Code-point traversal takes O(n) time in UTF-16 length and O(1) extra space.
    Try: Compare the counts for an accented letter represented with a combining mark.
*/

public class Unicode {
    public static void main(String[] args) {
        String text = "A\uD83D\uDE00B";

        System.out.println("code units=" + text.length());
        System.out.println("code points=" + text.codePointCount(0, text.length()));

        for (int i = 0; i < text.length();) {
            int point = text.codePointAt(i);

            System.out.println("U+" + Integer.toHexString(point));
            i += Character.charCount(point);           // <---- Skip both code units when this code point uses a surrogate pair.
        }
    }
}
