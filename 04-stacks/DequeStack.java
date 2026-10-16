/*
    ==== STACK WITH ARRAYDEQUE ====

    Deque supports operations at both ends. ArrayDeque implements it, and push, pop, and peek let
    us use one end as a stack.

    Complexity: push and pop are amortized O(1), meaning constant on average over many calls; peek
    O(1); storage O(n).
    Try: Replace push/pop with offerFirst/pollFirst and compare what happens when empty.
*/

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeStack {
    public static void main(String[] args) {
        Deque<Integer> stack = new ArrayDeque<>();

        stack.push(10);                                 // <---- Using the same end for push and pop makes the newest item leave first.
        stack.push(20);

        System.out.println(stack.peek());
        System.out.println(stack.pop());
    }
}
