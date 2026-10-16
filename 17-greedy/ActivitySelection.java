/*
    ==== ACTIVITY SELECTION ====

    Choose as many non-overlapping activities as possible. Sort by finish time, then select each
    activity that starts at or after the last selected one ends.

    Complexity: Time O(n log n) with sorting; scan O(n); extra space depends on sorting.
    Try: Find an example where choosing the earliest start leaves fewer activities than earliest
    finish.
*/

import java.util.*;

public class ActivitySelection {
    record Activity(int start, int end) {}

    public static void main(String[] args) {
        List<Activity> a =
                new ArrayList<>(
                        List.of(
                                new Activity(1, 4),
                                new Activity(3, 5),
                                new Activity(0, 6),
                                new Activity(5, 7),
                                new Activity(8, 9)));

        a.sort(Comparator.comparingInt(Activity::end));     // <---- An earlier finish leaves more time for later activities.

        int end = Integer.MIN_VALUE;

        for (Activity x : a) {
            if (x.start() >= end) {                         // <---- The activity is compatible because the previous one has finished.
                System.out.println(x);

                end = x.end();
            }
        }
    }
}
