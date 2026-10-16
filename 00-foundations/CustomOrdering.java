/*
    ==== ALTERNATE ORDERING WITH COMPARATOR ====

    A Comparator is an object that supplies a sorting rule. It lets the same Student objects be
    sorted by name, score, or another field.

    Complexity: Sorting takes O(n log n) comparisons. Comparing names can take O(L) for name
    length L, giving O(L * n log n) comparison work; library object sorting uses O(n) extra space.
    Try: Use thenComparing to break equal-name ties by score.
*/

import java.util.Arrays;
import java.util.Comparator;

public class CustomOrdering {
    static class Student {
        String name;
        int score;

        Student(String n, int s) {
            name = n;
            score = s;
        }
    }

    public static void main(String[] args) {
        Student[] students = {new Student("Mina", 88), new Student("Leo", 72)};

        Arrays.sort(students, Comparator.comparing(student -> student.name));       // <---- This Comparator compares names without changing the Student class.

        for (Student student : students) {
            System.out.println(student.name);
        }
    }
}
