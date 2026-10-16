/*
    ==== A GENERIC CONTAINER ====

    Generics let a class use a type parameter such as T. Box<String> replaces T with String, so
    the compiler can check what goes into the box.

    Complexity: Reading or replacing the single stored value takes O(1) time and space.
    Try: Change String to Integer and store a number.
*/

public class Generics {
    static class Box<T> {
        private T value;

        void set(T value) {
            this.value = value;
        }

        T get() {
            return value;
        }
    }

    public static void main(String[] args) {
        Box<String> box = new Box<>();                  // <---- The type parameter is String, so this box cannot store an Integer.

        box.set("ready");

        System.out.println(box.get().toUpperCase());
    }
}
