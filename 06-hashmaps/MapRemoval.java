/*
    ==== REMOVING FROM A BUCKET CHAIN ====

    A bucket chain is a linked list of entries that share an index. To remove a key, reconnect
    the previous node to the next node. Removing the first entry changes the bucket head. This
    fixed-size integer map isolates deletion from resizing.

    Complexity: Operations take O(b) for a bucket of b entries; storage O(n + buckets).
    Try: Remove the head, middle, tail, and a missing key from a chain.
*/

public class MapRemoval {
    static class Node {
        int key, value;
        Node next;

        Node(int key, int value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    static class Map {
        Node[] buckets = new Node[4];

        void put(int key, int value) {
            int index = Math.floorMod(key, buckets.length);

            for (Node node = buckets[index]; node != null; node = node.next) {
                if (node.key == key) {
                    node.value = value;
                    return;
                }
            }

            buckets[index] = new Node(key, value, buckets[index]);
        }

        Integer get(int key) {
            for (Node node = buckets[Math.floorMod(key, buckets.length)]; node != null; node = node.next) {
                if (node.key == key) {
                    return node.value;
                }
            }

            return null;
        }

        boolean remove(int key) {
            int index = Math.floorMod(key, buckets.length);
            Node previous = null;

            for (Node node = buckets[index]; node != null; node = node.next) {
                if (node.key == key) {
                    if (previous == null) {
                        buckets[index] = node.next;
                    } else {
                        previous.next = node.next;     // <---- Bypass the matching entry while preserving the rest of the chain.
                    }

                    return true;
                }

                previous = node;
            }

            return false;
        }
    }

    public static void main(String[] args) {
        Map map = new Map();

        map.put(1, 10);
        map.put(5, 50);
        map.put(9, 90);

        System.out.println(map.remove(5));
        System.out.println(map.get(1) + " " + map.get(9));
    }
}
