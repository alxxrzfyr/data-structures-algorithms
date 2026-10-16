/*
    ==== KEY AND VALUE ====

    A map uses a key to look up a value. Each key has one current value, so storing that key again
    replaces its previous value.

    Complexity: A HashMap lookup is expected O(1); iteration across n entries is O(n).
    Try: Replace a value for the same key and confirm the map still has one entry.
*/

import java.util.HashMap;
import java.util.Map;

public class KeyValuePairs {
    public static void main(String[] args) {
        Map<String, String> capital = new HashMap<>();

        capital.put("Japan", "Tokyo");
        capital.put("Japan", "Kyoto");                  // <---- The key Japan already exists, so this replaces its old value.

        System.out.println(capital.size() + " " + capital.get("Japan"));
    }
}
