/*
    ==== DELETION WITH LINEAR PROBING ====

    A deleted slot, or tombstone, says that probing must continue. An unused slot says the key
    was never placed farther along this probe chain. New entries can reuse deleted slots, but
    must first check that the key is not already stored later in the chain.

    Complexity: Operations take O(capacity) worst-case time; expected O(1) at low load with
    suitable hashing. Fixed storage O(capacity), no resizing.
    Try: Fill the table, remove an entry, then reuse its slot without breaking lookup.
*/

public class Tombstones {
    static class Map {
        int[] keys = new int[7], values = new int[7];
        byte[] state = new byte[7];                    // <---- 0 means unused, 1 occupied, and 2 deleted.

        int find(int key) {
            int start = Math.floorMod(key, keys.length);

            for (int step = 0; step < keys.length; step++) {
                int i = (start + step) % keys.length;

                if (state[i] == 0) {
                    return -1;
                }

                if (state[i] == 1 && keys[i] == key) {
                    return i;
                }
            }

            return -1;
        }

        Integer get(int key) {
            int index = find(key);

            return index < 0 ? null : values[index];
        }

        void put(int key, int value) {
            int index = find(key);

            if (index >= 0) {
                values[index] = value;
                return;
            }

            int start = Math.floorMod(key, keys.length);

            for (int step = 0; step < keys.length; step++) {
                int i = (start + step) % keys.length;

                if (state[i] != 1) {
                    keys[i] = key;
                    values[i] = value;
                    state[i] = 1;
                    return;
                }
            }

            throw new IllegalStateException("full");
        }

        boolean remove(int key) {
            int index = find(key);

            if (index < 0) {
                return false;
            }

            state[index] = 2;                          // <---- Mark deleted instead of unused so later colliding keys remain reachable.

            return true;
        }
    }

    public static void main(String[] args) {
        Map map = new Map();

        map.put(1, 10);
        map.put(8, 80);
        map.remove(1);

        System.out.println(map.get(8));
        map.put(15, 150);
        System.out.println(map.get(15));
    }
}
