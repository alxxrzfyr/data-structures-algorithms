/*
    ==== A SMALL HASH MAP ====

    A hash map stores key-value pairs in buckets chosen from the keys' hash codes. This small
    version uses a list in each bucket to handle collisions.

    Complexity: get and put scan one bucket list: O(b) time for b entries in that bucket. Total
    storage is O(n).
    Try: Add remove(key), and decide how its result should report a missing key.
*/

import java.util.ArrayList;
import java.util.List;

public class CustomHashMap {
    static class Pair {
        String key;
        int value;

        Pair(String k, int v) {
            key = k;
            value = v;
        }
    }

    static class SimpleMap {
        List<Pair>[] buckets = new List[8];

        SimpleMap() {
            for (int i = 0; i < buckets.length; i++) {
                buckets[i] = new ArrayList<>();
            }
        }

        int index(String key) {
            return Math.floorMod(key.hashCode(), buckets.length);
        }

        void put(String key, int value) {
            for (Pair p : buckets[index(key)]) {                // <---- Search this bucket for the same key before creating another entry.
                if (p.key.equals(key)) {
                    p.value = value;
                    return;
                }
            }

            buckets[index(key)].add(new Pair(key, value));      // <---- The key was not found, so add a new pair to this bucket.
        }

        Integer get(String key) {
            for (Pair p : buckets[index(key)]) {
                if (p.key.equals(key)) {
                    return p.value;
                }
            }

            return null;                                        // <---- No entry in this bucket matched the key, so report it as missing.
        }
    }

    public static void main(String[] args) {
        SimpleMap map = new SimpleMap();

        map.put("Ada", 42);
        map.put("Ada", 43);

        System.out.println(map.get("Ada"));
    }
}
