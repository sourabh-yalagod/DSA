package intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solutions {
    public static void main(String[] args) {
        int[][] interval = {{1, 3}, {7, 9}};
        int[] newInterval = {2, 4};
        interval = insert(interval, newInterval);
        for (int i = 0; i < interval.length; i++) {
            System.out.print(" " + Arrays.toString(interval[i]));
        }
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int start = newInterval[0];
        int end = newInterval[1];
        int n = intervals.length;
        for (int i = 0; i < n; i++) {
            if (start >= intervals[i][0] && end > intervals[i][1]) {
                int[][] temp = new int[n + 1][2];
                int index = 0;
                boolean inserted = false;

                for (int j = 0; j < temp.length; j++) {
                    if (!inserted && (index == n || start < intervals[index][0])) {
                        temp[j] = newInterval;
                        inserted = true;
                    } else {
                        temp[j] = intervals[index++];
                    }
                }
                return mergeIntervals(temp);
            }
        }
        return mergeIntervals(intervals);
    }

    private static int[][] mergeIntervals(int[][] intervals) {
        // {{1, 3}, {4, 8}, {7, 9}}
        List<int[]> list = new ArrayList<>();
        int[] interval = intervals[0];
        int n = intervals.length;
        for (int i = 1; i < n; i++) {
            if (interval[1] >= intervals[i][0]) {
                interval[1] = Math.max(intervals[i][1], interval[1]);
            } else {
                list.add(interval);
                interval = intervals[i];
            }
        }
        list.add(interval);
        int[][] result = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
