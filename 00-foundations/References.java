/*
    ==== OBJECT REFERENCES ====

    An object reference lets a variable refer to an object. Assigning a reference to another
    variable does not create a second object.

    Complexity: Reference assignment is O(1); copying an array of n values takes O(n).
    Try: Set second to a new Box and observe that first still points to the original.
*/

public class References {
    static class Box {
        int value;

        Box(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Box first = new Box(10);
        Box second = first;                             // <---- Both variables refer to the same Box; changing it through either name affects it.

        second.value = 25;

        System.out.println(first.value);
    }
}
