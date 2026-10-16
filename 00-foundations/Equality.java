/*
    ==== IDENTITY AND VALUE EQUALITY ====

    For objects, == asks whether two references identify the same object. equals can compare
    meaningful values instead. Equal objects must have equal hash codes; unequal objects may
    still share a hash code. Keep fields used for equality stable while an object is a map key.

    Complexity: This integer-key equality and hashing take O(1) time and extra space.
    Try: Compare a key with null and with an object of a different class.
*/

public class Equality {
    static final class Key {
        private final int id;

        Key(int id) {
            this.id = id;
        }

        @Override
        public boolean equals(Object other) {
            return other instanceof Key && id == ((Key) other).id;   // <---- Separate objects can represent the same logical key.
        }

        @Override
        public int hashCode() {
            return Integer.hashCode(id);                             // <---- Use the same field as equals so equal keys receive equal hash codes.
        }
    }

    public static void main(String[] args) {
        Key first = new Key(7);
        Key second = new Key(7);

        System.out.println(first == second);
        System.out.println(first.equals(second));
        System.out.println(first.hashCode() == second.hashCode());
    }
}
