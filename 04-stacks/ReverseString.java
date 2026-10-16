/*
    ==== REVERSE A STRING WITH A STACK ====

    Push characters onto a stack in their original order. Popping returns them backward because a
    stack removes the newest item first.

    Complexity: Time O(n), extra space O(n).
    Try: Compare with reversing an array in place.
*/

import java.util.ArrayDeque;
import java.util.Deque;

public class ReverseString {
    public static void main(String[] args) {
        String text = "stack";
        Deque<Character> s = new ArrayDeque<>();

        for (char c : text.toCharArray()) {
            s.push(c);
        }

        StringBuilder out = new StringBuilder();

        while (!s.isEmpty()) {                          // <---- The final character pushed is the first one added to the result.
            out.append(s.pop());
        }

        System.out.println(out);
    }
}
