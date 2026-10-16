/*
    ==== COMPARE SORTING CHOICES ====

    Compare best, average, and worst time, extra memory, and stability. Stability preserves the
    original order of equal keys. The two manual methods below sort tagged items by key:
    insertion sort preserves tied labels, while selection sort can reverse them. Complexity
    bounds assume constant-time key comparisons.

    Complexity: This demonstration uses O(n squared) sorting time and O(n) copied storage. The
    printed table describes the corresponding lesson implementations.
    Try: Count comparisons on sorted and reversed inputs, then explain why timing one tiny input
    cannot prove a Big O bound.
*/

import java.util.Arrays;

public class Comparison {
    record Item(int key, String label) {}

    static void insertion(Item[] items) {
        for (int i = 1; i < items.length; i++) {
            Item value = items[i];
            int j = i - 1;

            while (j >= 0 && items[j].key() > value.key()) {
                items[j + 1] = items[j];
                j--;
            }

            items[j + 1] = value;                      // <---- Strictly larger keys move; equal keys retain their original order.
        }
    }

    static void selection(Item[] items) {
        for (int i = 0; i < items.length; i++) {
            int smallest = i;

            for (int j = i + 1; j < items.length; j++) {
                if (items[j].key() < items[smallest].key()) {
                    smallest = j;
                }
            }

            Item value = items[i];

            items[i] = items[smallest];
            items[smallest] = value;                   // <---- A distant swap can move one tied item past another.
        }
    }

    public static void main(String[] args) {
        System.out.println("sort       best       average    worst      extra space stable");
        System.out.println("bubble     O(n)       O(n^2)     O(n^2)     O(1)        yes");
        System.out.println("selection  O(n^2)     O(n^2)     O(n^2)     O(1)        no");
        System.out.println("insertion  O(n)       O(n^2)     O(n^2)     O(1)        yes");
        System.out.println("merge      O(n log n) O(n log n) O(n log n) O(n)        yes");
        System.out.println("quick      O(n log n) O(n log n) O(n^2)     O(log n)    no");
        System.out.println("heap       O(n log n) O(n log n) O(n log n) O(1)        no");
        System.out.println("counting   O(n+k)     O(n+k)     O(n+k)     O(n+k)      integer-only output");
        System.out.println("radix      O(d(n+b))  O(d(n+b))  O(d(n+b))  O(n+b)      yes");
        System.out.println("k=key range, d=digits, b=radix base");

        Item[] first = {new Item(2, "A"), new Item(2, "B"), new Item(1, "C")};
        Item[] second = first.clone();

        insertion(first);
        selection(second);

        System.out.println("insertion: " + Arrays.toString(first));
        System.out.println("selection: " + Arrays.toString(second));
    }
}
