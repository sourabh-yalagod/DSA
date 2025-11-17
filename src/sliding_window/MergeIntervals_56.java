package sliding_window;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals_56 {
    public static void main(String[] args) {
        int[][] inter = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] merged = merge(inter);
        for (int i = 0; i < merged.length; i++) {
            for (int j = 0; j < merged[i].length; j++) {
                System.out.print(merged[i][j]+" ");
            }
            System.out.print(" - ");
        }
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt((ele) -> ele[0]));
        List<int[]> list = new ArrayList<>();
        int[] newInterval = intervals[0];
        list.add(newInterval);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= newInterval[1]) {
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            } else {
                newInterval = intervals[i];
                list.add(newInterval);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
