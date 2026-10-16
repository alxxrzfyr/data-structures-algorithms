/*
    ==== MERGING SORTED SEQUENCES ====

    Each sorted sequence supplies one smallest remaining candidate. A min heap selects the
    smallest candidate across sequences. After taking it, insert the next value from that same
    sequence. The heap never needs every input element at once.

    Complexity: Time O(k + N log(k + 1)), heap space O(k), plus O(N) output, for k sequences and
    N total values. Each input must already be sorted.
    Try: Explain why an empty sequence adds no initial candidate.
*/

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeSorted {
    record Item(int value, int row, int column) {}

    static int[] merge(int[][] rows) {
        PriorityQueue<Item> heap = new PriorityQueue<>(Comparator.comparingInt(Item::value));
        int size = 0;

        for (int row = 0; row < rows.length; row++) {
            size = Math.addExact(size, rows[row].length);

            if (rows[row].length > 0) {
                heap.offer(new Item(rows[row][0], row, 0));
            }
        }

        int[] result = new int[size];
        int index = 0;

        while (!heap.isEmpty()) {
            Item item = heap.poll();

            result[index++] = item.value();

            int next = item.column() + 1;

            if (next < rows[item.row()].length) {
                heap.offer(new Item(rows[item.row()][next], item.row(), next));   // <---- Replace only the candidate consumed from this sequence.
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(merge(new int[][] {{1, 4}, {}, {2, 3, 8}})));
    }
}
