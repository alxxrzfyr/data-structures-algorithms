/*
    ==== SET BASICS ====

    A set stores unique values. A membership check asks whether a value is already in the set.

    Complexity: Expected add and contains O(1); space O(n).
    Try: Print each unique value once while preserving the original order with LinkedHashSet.
*/

import java.util.HashSet;
import java.util.Set;

public class Basics {
    public static void main(String[] args) {
        Set<String> s = new HashSet<>();

        s.add("red");
        s.add("blue");
        s.add("red");

        System.out.println(s.size());                   // <---- Adding red twice still creates only one red entry.
    }
}
