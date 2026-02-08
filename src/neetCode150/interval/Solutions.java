package neetCode150.interval;

import java.util.*;

public class Solutions {
    public static void main(String[] args) {

    }

    public boolean canAttendMeetings(List<Interval> intervals) {
        if (intervals.isEmpty()) return true;
        Interval interval = intervals.getFirst();
        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).start > interval.end) {
                interval = intervals.get(i);
            } else return false;
        }
        return true;
    }

    public int[] minInterval(int[][] intervals, int[] queries) {
        int n = queries.length;
        Map<Integer, List<int[]>> map = new HashMap<>();
        int[] starts = new int[n];
        int index = 0;
        for (int[] interval : intervals) {
            List<int[]> list = map.getOrDefault(interval[0], new ArrayList<>());
            starts[index++] = interval[0];
            list.add(interval);
            map.put(interval[0], list);
        }
        Arrays.sort(starts);
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int query = binarySearch(starts, 0, queries[i], starts.length - 1);
            List<int[]> inters = map.get(query);
            int[] resultInter = new int[2];
            int resultInterVal = Integer.MAX_VALUE;
            for (int[] in : inters) {
                if (resultInterVal > in[1] - in[0]) {
                    resultInterVal = in[1] - in[0];
                    resultInter = in;
                }
            }
            result[i] = resultInter[1] - resultInter[0] + queries[i];
        }
        return result;
    }

    private int binarySearch(int[] array, int target, int i, int j) {
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (array[mid] == target) return mid;
            else if (array[mid] > target) i = mid + 1;
            else j = mid - 1;
        }
        return i;
    }
}
