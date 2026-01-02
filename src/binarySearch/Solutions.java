package binarySearch;

public class Solutions {
    public static void main(String[] args) {
        int[] array = {6, 8, 9, 5, 4, 3, 2};
        int[][] matrix = {{1, 2, 4, 8}, {10, 11, 12, 13}, {14, 20, 30, 40}};
        int[] piles = {1, 4, 3, 2};
        int h = 9;
        System.out.println(findMinInRotatedArray(array));
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
}
