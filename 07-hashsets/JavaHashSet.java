/*
    ==== JAVA HASHSET ====

    HashSet uses hashing for fast membership checks. It stores each value once, but does not
    guarantee the order in which values are visited.

    Complexity: Expected add/contains/remove O(1); worst case O(n).
    Try: Use LinkedHashSet if keeping insertion order is part of the requirement.
*/

import java.util.HashSet;
import java.util.Set;

public class JavaHashSet {
    public static void main(String[] args) {
        Set<String> names = new HashSet<>();

        names.add("Ada");
        names.add("Grace");
        names.add("Ada");

        System.out.println(names.size());               // <---- The second Ada does not add a new entry because Ada is already present.
        System.out.println(names.contains("Grace"));
    }
}
