package binarySearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solutions {
    public static void main(String[] args) {
        int[] array = {9, 3, 1, 0};
        System.out.println(peakInMountainArray(array));
    }

    private static int binarySearch(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (array[mid] == target) return mid;
            else if (array[mid] > target) high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }

    private static int searchInMatrix(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) return matrix[row][col];
            else if (matrix[row][col] > target) col--;
            else row++;
        }
        return -1;
    }

    private static int kokoEatingBanana(int[] array, int hours) {
        int count = 0;
        int low = 1;
        int high = Integer.MIN_VALUE;
        for (int ele : array) high = Math.max(high, ele);
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int h = hours;
            for (int i = 0; i < array.length; i++) {
                int rem = array[i] % mid;
                h -= (array[i] / mid);
                if (rem > 0) h--;
                if (h < 0) {
                    high = mid - 1;
                }
            }
            if (h >= 0)
                low = mid + 1;
        }
        return high;
    }

    private static int findMinInRotatedArray(int[] array) {
        int min = 0;
        int low = 0;
        int high = array.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (array[low] < array[mid]) low = mid + 1;
            else high = mid;
        }
        return low;
    }

    private static int peekInMountainArray(int[] array) {
        int low = 0;
        int high = array.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (array[mid] > array[mid + 1]) high = mid;
            else low = mid + 1;
        }
        return low;
    }

    static class TimeMap {
        private Map<String, List<Pair>> map = null;

        public TimeMap() {
            this.map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            map.putIfAbsent(key, new ArrayList<Pair>());
            map.get(key).add(new Pair(value, timestamp));
        }

        public String get(String key, int timestamp) {
            if (!map.containsKey(key)) return "";
            List<Pair> list = map.get(key);
            int low = 0;
            int high = list.size() - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (list.get(mid).timeStamps <= timestamp) low = mid + 1;
                else high = mid - 1;
            }
            return list.get(high).value;
        }

        class Pair {
            private String value;
            private int timeStamps;

            public Pair(String value, int timeStamps) {
                this.value = value;
                this.timeStamps = timeStamps;
            }
        }
    }

    private static int searchInRotatedArray(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (array[mid] == target) return mid;
            if (array[low] <= array[mid]) {
                if (array[low] <= target && target < array[mid]) high = mid - 1;
                else low = mid + 1;
            } else {
                if (array[mid] <= target && target <= array[high]) low = mid + 1;
                else high = mid - 1;
            }
        }
        return -1;
    }

    private static int peakInMountainArray(int[] array) {
        int low = 0;
        int high = array.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (array[mid] < array[mid + 1]) low = mid + 1;
            else high = mid;
        }
        return low;
    }
}
