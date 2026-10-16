/*
    ==== A SMALL DYNAMIC ARRAY ====

    A dynamic array tracks size and capacity separately. Size counts stored items; capacity is the
    space in the internal array. Grow the array when it is full.

    Complexity: Append amortized O(1), or constant on average across many adds; resizing copies n
    items. get O(1); storage O(capacity).
    Try: Add enough values to trigger two resizes and print the capacity each time.
*/

import java.util.Arrays;

public class CustomArrayList {
    static class IntList {
        private int[] data = new int[2];
        private int size;

        void add(int value) {
            if (size == data.length) {                  // <---- Resize only when full; the new spare slots make later adds cheaper.
                data = Arrays.copyOf(data, data.length * 2);
            }

            data[size++] = value;                       // <---- Write into the next free slot, then increase the item count.
        }

        int get(int index) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException();
            }

            return data[index];
        }

        int size() {
            return size;
        }
    }

    public static void main(String[] args) {
        IntList list = new IntList();

        for (int value = 1; value <= 5; value++) {
            list.add(value * 10);
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
