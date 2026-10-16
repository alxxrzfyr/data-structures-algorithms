/*
    ==== BALANCED PARENTHESES ====

    A stack remembers opening brackets. Each closing bracket must match the opening bracket on
    top, because nested brackets close from the inside out.

    Complexity: Time O(n), extra space O(n).
    Try: Test ([)], which has the right counts but the wrong nesting order.
*/

import java.util.ArrayDeque;
import java.util.Deque;

public class BalancedParentheses {
    static boolean balanced(String text) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : text.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);                          // <---- Push the opening bracket so it can be matched later.
            } else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) {
                    return false;
                }

                char open = stack.pop();                // <---- The top holds the most recent opening bracket that still needs a match.

                if ((c == ')' && open != '(')
                        || (c == ']' && open != '[')
                        || (c == '}' && open != '{')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();                         // <---- An opening bracket left in the stack means the input is incomplete.
    }

    public static void main(String[] args) {
        System.out.println(balanced("{[()] }"));
    }
}
