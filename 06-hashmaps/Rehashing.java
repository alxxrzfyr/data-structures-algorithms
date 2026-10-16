/*
    ==== LOAD FACTOR AND REHASHING ====

    Load factor is entry count divided by bucket count. When too many entries share a small
    table, allocate more buckets and recompute every entry's index. An index depends on
    capacity, so copying bucket positions directly would be wrong. This integer-key map doubles
    at a load factor above 0.75.

    Complexity: Expected get/put time is amortized O(1) with well-spread hashes; a resize takes
    O(n). Worst lookup O(n); storage O(n).
    Try: Use keys that land in one bucket and explain why resizing alone cannot guarantee short
    chains.
*/

public class Rehashing {
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
        int size;

        Integer get(int key) {
            for (Node node = buckets[Math.floorMod(key, buckets.length)]; node != null; node = node.next) {
                if (node.key == key) {
                    return node.value;
                }
            }

            return null;
        }

        void put(int key, int value) {
            int index = Math.floorMod(key, buckets.length);

            for (Node node = buckets[index]; node != null; node = node.next) {
                if (node.key == key) {
                    node.value = value;
                    return;
                }
            }

            buckets[index] = new Node(key, value, buckets[index]);
            size++;

            if (size > buckets.length * 0.75) {
                resize();
            }
        }

        void resize() {
            Node[] old = buckets;

            buckets = new Node[old.length * 2];

            for (Node head : old) {
                while (head != null) {
                    Node next = head.next;
                    int index = Math.floorMod(head.key, buckets.length);

                    head.next = buckets[index];        // <---- Relink this node using its index under the new capacity.
                    buckets[index] = head;
                    head = next;
                }
            }
        }
    }

    public static void main(String[] args) {
        Map map = new Map();

        for (int i = 0; i < 10; i++) {
            map.put(i, i * 10);
        }

        System.out.println("size=" + map.size + ", capacity=" + map.buckets.length);
        System.out.println(map.get(7));
    }
}
