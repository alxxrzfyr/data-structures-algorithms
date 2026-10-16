/*
    ==== OPEN ADDRESSING ====

    Open addressing stores keys directly in an array. Linear probing handles a collision by
    checking the next slot until it finds the key or an empty slot. This fixed-size example
    assumes an empty slot is available when adding a new key.

    Complexity: get/put are expected O(1) with few collisions; worst case O(n). Storage is
    O(capacity). This example has no resize.
    Try: Explain why deletion needs a deleted-slot marker instead of simply clearing a slot.
*/

public class OpenAddressing {
    static class Table {
        String[] keys = new String[7];
        Integer[] values = new Integer[7];

        int index(String k) {
            return Math.floorMod(k.hashCode(), keys.length);
        }

        void put(String k, int v) {
            int i = index(k), start = i;

            while (keys[i] != null && !keys[i].equals(k)) {     // <---- If this slot holds another key, check the next slot, wrapping if needed.
                i = (i + 1) % keys.length;

                if (i == start) {
                    throw new IllegalStateException("full");
                }
            }

            keys[i] = k;
            values[i] = v;
        }

        Integer get(String k) {
            int i = index(k), start = i;

            while (keys[i] != null) {
                if (keys[i].equals(k)) {
                    return values[i];
                }

                i = (i + 1) % keys.length;

                if (i == start) {                               // <---- Reaching the starting slot again means every slot was checked.
                    break;
                }
            }

            return null;
        }
    }

    public static void main(String[] args) {
        Table t = new Table();

        t.put("Ada", 1);
        t.put("Grace", 2);

        System.out.println(t.get("Ada"));
    }
}
