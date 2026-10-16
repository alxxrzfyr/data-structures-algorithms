/*
    ==== EVALUATE A POSTFIX EXPRESSION ====

    A postfix expression puts operators after their operands, the numbers they use. Push numbers
    onto a stack; an operator pops its operands and pushes the result.

    Complexity: Time O(n), extra space O(n).
    Try: Evaluate 8 2 / 3 - by hand before running the program.
*/

import java.util.ArrayDeque;
import java.util.Deque;

public class Postfix {
    public static void main(String[] args) {
        String[] tokens = {"5", "2", "+", "3", "*"};
        Deque<Integer> s = new ArrayDeque<>();

        for (String t : tokens) {
            if (t.matches("-?\\d+")) {
                s.push(Integer.parseInt(t));
            } else {
                int right = s.pop(), left = s.pop();    // <---- Pop right before left: 8 - 2 must not accidentally become 2 - 8.

                s.push(
                        t.equals("+")
                                ? left + right
                                : t.equals("-")
                                        ? left - right
                                        : t.equals("*") ? left * right : left / right);
            }
        }

        System.out.println(s.pop());
    }
}
