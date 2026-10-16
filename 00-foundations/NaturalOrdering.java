/*
    ==== NATURAL ORDERING WITH COMPARABLE ====

    Comparable gives a class its natural, or default, sorting order. Its compareTo method returns
    a negative number, zero, or a positive number to compare two objects.

    Complexity: Sorting n values takes O(n log n) comparisons on average for common library sorts.
    Try: Change compareTo to sort by name instead of score.
*/

import java.util.Arrays;

public class NaturalOrdering {
    static class Student implements Comparable<Student> {
        String name;
        int score;

        Student(String name, int score) {
            this.name = name;
            this.score = score;
        }

        public int compareTo(Student other) {
            return Integer.compare(score, other.score);     // <---- A lower score returns a negative number, so that student comes first.
        }
    }

    public static void main(String[] args) {
        Student[] classList = {new Student("Mina", 88), new Student("Leo", 72)};

        Arrays.sort(classList);                             // <---- Arrays.sort uses compareTo because no separate Comparator was given.

        for (Student student : classList) {
            System.out.println(student.name + ": " + student.score);
        }
    }
}
