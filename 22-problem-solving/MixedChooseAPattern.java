/*
    ==== CHOOSE A PATTERN FROM THE INPUT ====

    A problem's input can suggest a useful algorithm pattern. Before using it, check its
    requirements, such as sorted values for two pointers or suitable weights for a graph
    algorithm.

    Complexity: This is a decision guide, not an algorithm; analyze the chosen algorithm
    separately.
    Try: Choose a pattern and give an input that breaks one of its requirements.
*/

public class MixedChooseAPattern {
    public static void main(String[] args) {
        System.out.println("Sorted input + pair target -> consider two pointers");      // <---- Use the clue to suggest a pattern, then check its requirements before coding.
        System.out.println("Contiguous range + positive values -> consider sliding window");
        System.out.println("Repeated prefix questions -> consider prefix sums");
        System.out.println("Shortest path with equal edge cost -> consider BFS");
        System.out.println("Repeated overlapping subproblems -> consider dynamic programming");
    }
}
