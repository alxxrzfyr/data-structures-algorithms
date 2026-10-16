/*
    ==== BUILDING A SET MANUALLY ====

    A hash set stores keys without separate values. This integer set hashes into bucket chains
    and checks membership before inserting, so duplicate values do not create extra nodes. The
    fixed bucket count keeps the example focused on uniqueness.

    Complexity: Operations take O(b) for a bucket containing b keys; total storage O(n +
    buckets). No resizing.
    Try: Add a remove operation that returns whether the set contained the key.
*/

public class CustomHashSet {
    static class Node {
        int value;
        Node next;

        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    static class Set {
        Node[] buckets = new Node[8];
        int size;

        boolean contains(int value) {
            for (Node node = buckets[Math.floorMod(value, buckets.length)]; node != null; node = node.next) {
                if (node.value == value) {
                    return true;
                }
            }

            return false;
        }

        boolean add(int value) {
            if (contains(value)) {
                return false;                          // <---- An existing value already represents membership in the set.
            }

            int index = Math.floorMod(value, buckets.length);

            buckets[index] = new Node(value, buckets[index]);
            size++;

            return true;
        }
    }

    public static void main(String[] args) {
        Set set = new Set();

        System.out.println(set.add(3));
        System.out.println(set.add(3));
        System.out.println(set.contains(3));
        System.out.println(set.size);
    }
}
