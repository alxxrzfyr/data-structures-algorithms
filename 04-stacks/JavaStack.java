/*
    ==== LEGACY JAVA.UTIL.STACK ====

    java.util.Stack is an older stack class. Its methods are synchronized to coordinate access
    between threads. For new stack code, ArrayDeque through the Deque interface is usually
    simpler.

    Complexity: push/pop/peek O(1) typical; searching O(n).
    Try: Rewrite the example with ArrayDeque from the Deque Stack lesson.
*/

import java.util.Stack;

public class JavaStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(4);                                  // <---- After pushing 4 and then 9, pop removes 9 first.
        stack.push(9);

        System.out.println(stack.peek());
        System.out.println(stack.pop());
    }
}
