/*
    ==== HASHING A KEY ====

    A hash code is an integer calculated from a key. Use it to choose a bucket, the storage slot
    where the map will look for that key.

    Complexity: The first string hash can take O(L) for L characters; calculating the bucket from
    that hash is O(1).
    Try: Print bucket indexes for several keys and increase the table capacity.
*/

public class Hashing {
    static int bucket(String key, int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity must be positive");
        }

        return Math.floorMod(key.hashCode(), capacity);     // <---- floorMod turns the hash code into an index from 0 to capacity - 1.
    }

    public static void main(String[] args) {
        for (String key : new String[] {"ant", "bee", "cat", "dog"}) {
            System.out.println(key + " -> " + bucket(key, 5));
        }
    }
}
