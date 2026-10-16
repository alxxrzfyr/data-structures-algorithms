/*
    ==== WHY MAP KEYS SHOULD STAY STABLE ====

    A hash map selects a bucket when a key is inserted. Changing a field used by equals and
    hashCode does not move that entry. A later lookup can search a different bucket and fail.
    Prefer immutable keys, or remove a key before changing and reinserting it.

    Complexity: Expected put/get time O(1) here; storage O(n). This deliberately demonstrates a
    broken key usage.
    Try: Make id final and use a new key object when the identifier changes.
*/

import java.util.HashMap;
import java.util.Map;

public class MutableKeys {
    static final class Key {
        int id;

        Key(int id) {
            this.id = id;
        }

        @Override
        public boolean equals(Object other) {
            return other instanceof Key && id == ((Key) other).id;
        }

        @Override
        public int hashCode() {
            return id;
        }
    }

    public static void main(String[] args) {
        Map<Key, String> map = new HashMap<>();
        Key key = new Key(1);

        map.put(key, "Ada");
        key.id = 2;                                    // <---- The entry stays in its old bucket even though this key now hashes differently.

        System.out.println(map.get(key));
        System.out.println(map.size());
    }
}
