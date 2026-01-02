package binarySearch;

public class Solutions {
    public static void main(String[] args) {
        int[] array = {1, 2, 4, 5, 6, 10, 11};
        int[][]  matrix= {{1, 2, 4, 8}, {10, 11, 12, 13}, {14, 20, 30, 40}};
        System.out.println(searchInMatrix(matrix, 14));
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
}
