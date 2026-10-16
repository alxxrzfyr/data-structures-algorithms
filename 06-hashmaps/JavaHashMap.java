/*
    ==== JAVA HASHMAP ====

    HashMap manages buckets, collisions, and resizing for you. equals decides whether keys match;
    matching keys must also have matching hash codes.

    Complexity: Expected put/get/remove O(1); worst case O(n).
    Try: Look up an absent word with getOrDefault and choose a fallback value.
*/

import java.util.HashMap;
import java.util.Map;

public class JavaHashMap {
    public static void main(String[] args) {
        Map<String, Integer> ages = new HashMap<>();

        ages.put("Ada", 36);
        ages.put("Linus", 56);

        System.out.println(ages.get("Ada"));
        System.out.println(ages.getOrDefault("Grace", 0));      // <---- Grace is missing, so getOrDefault returns the fallback value 0.
    }
}
