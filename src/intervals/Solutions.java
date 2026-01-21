package intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solutions {
    public static void main(String[] args) {
        int[][] interval = {{-3, -1}, {1, 4}, {7, 9}};
        int[] newInterval = {5, 6};
        int[][] intervals = insert(interval, newInterval);
        for (int i = 0; i < intervals.length; i++) {
            System.out.print(" " + Arrays.toString(intervals[i]));
        }
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        // {-3, -1}, {1, 4}, {7, 9}
        int start = newInterval[0];
        int end = newInterval[1];
        int[] interval = intervals[0];
        for (int i = 0; i < intervals.length; i++) {
            System.out.println(interval[1]);
            if (interval[1] < start) {
                list.add(interval);
                interval = intervals[i];
            } else {
                list.add(newInterval);
                start = Integer.MIN_VALUE;
                i--;
            }
        }
        return list.toArray(new int[2][list.size()]);
    }

    private static int[][] mergeInterval(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        int[] interval = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (interval[1] < intervals[i][0]) {
                list.add(interval);
                interval = intervals[i];
            } else {
                interval[0] = Math.min(interval[0], intervals[i][0]);
                interval[1] = Math.max(interval[1], intervals[i][1]);
            }
        }
        list.add(interval);
        return list.toArray(new int[list.size()][2]);
    }
}
