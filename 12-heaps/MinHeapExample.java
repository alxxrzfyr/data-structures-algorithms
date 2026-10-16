/*
    ==== A MIN HEAP ====

    A min heap keeps each parent no larger than its children. Insert by sifting up; after removing
    the root, put the last item there and sift it down.

    Complexity: add/remove take O(log n), apart from occasional internal-array growth; n items use
    O(n) storage.
    Try: Print the backing array after insertion; it obeys the heap rule but is not sorted.
*/

import java.util.ArrayList;
import java.util.List;

public class MinHeapExample {
    static class MinHeap {
        List<Integer> a = new ArrayList<>();

        void add(int v) {
            a.add(v);

            int i = a.size() - 1;

            while (i > 0) {                             // <---- Sift up by swapping with a larger parent until the order is correct.
                int p = (i - 1) / 2;

                if (a.get(p) <= a.get(i)) {
                    break;
                }

                swap(p, i);
                i = p;
            }
        }

        int remove() {
            int result = a.get(0), last = a.remove(a.size() - 1);

            if (!a.isEmpty()) {
                a.set(0, last);                         // <---- Fill the root's gap with the last item, then move it down if needed.
                down(0);
            }

            return result;
        }

        void down(int i) {
            while (2 * i + 1 < a.size()) {
                int c = 2 * i + 1;                      // <---- Compare the children so we can swap with the smaller one.

                if (c + 1 < a.size() && a.get(c + 1) < a.get(c)) {
                    c++;
                }

                if (a.get(i) <= a.get(c)) {
                    break;
                }

                swap(i, c);
                i = c;
            }
        }

        void swap(int i, int j) {
            int t = a.get(i);

            a.set(i, a.get(j));
            a.set(j, t);
        }
    }

    public static void main(String[] args) {
        MinHeap h = new MinHeap();

        for (int v : new int[] {7, 2, 6, 1}) {
            h.add(v);
        }

        while (!h.a.isEmpty()) {
            System.out.println(h.remove());
        }
    }
}
