/*
    ==== COLLISION CHAINING ====

    A hash table uses buckets to store entries. A collision happens when different keys use the
    same bucket. Chaining keeps those entries together in a list.

    Complexity: Storing n entries takes O(n) time here; lookup scans one bucket list. Space is O(n
    + bucket count).
    Try: Change the capacity to one so every key collides.
*/

import java.util.LinkedList;
import java.util.List;

public class Chaining {
    static class Entry {
        String key;
        int value;

        Entry(String k, int v) {
            key = k;
            value = v;
        }
    }

    public static void main(String[] args) {
        List<Entry>[] buckets = new List[3];

        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<>();
        }

        for (Entry e :
                new Entry[] {new Entry("ant", 1), new Entry("bee", 2), new Entry("cat", 3)}) {
            buckets[Math.floorMod(e.key.hashCode(), buckets.length)].add(e);    // <---- Store the entry in its bucket's list, even if other keys are there.
        }

        for (int i = 0; i < buckets.length; i++) {
            System.out.println(i + ": " + buckets[i].size() + " entries");
        }
    }
}
