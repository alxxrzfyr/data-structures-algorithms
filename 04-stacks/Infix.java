/*
    ==== CONVERT INFIX TO POSTFIX ====

    Infix puts an operator between numbers, like 3 + 4. Postfix puts it after them, like 3 4 +. A
    stack keeps operators in the right order. This example has single-digit numbers and no
    parentheses.

    Complexity: Time O(n), extra space O(n).
    Try: Add parentheses handling or multi-digit tokens.
*/

import java.util.ArrayDeque;
import java.util.Deque;

public class Infix {
    static int precedence(char c) {
        return c == '+' || c == '-' ? 1 : 2;
    }

    public static void main(String[] args) {
        String input = "3+4*2";
        StringBuilder out = new StringBuilder();
        Deque<Character> ops = new ArrayDeque<>();

        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                out.append(c).append(' ');
            } else {
                while (!ops.isEmpty() && precedence(ops.peek()) >= precedence(c)) {     // <---- Output operators that must happen first before storing the new one.
                    out.append(ops.pop()).append(' ');
                }

                ops.push(c);
            }
        }

        while (!ops.isEmpty()) {
            out.append(ops.pop()).append(' ');
        }

        System.out.println(out.toString().trim());
    }
}
