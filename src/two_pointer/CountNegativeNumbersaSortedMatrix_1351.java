package two_pointer;

public class CountNegativeNumbersaSortedMatrix_1351 {
    public static void main(String[] args) {
        int[][] matrix = {
                {4, 3, 2, -1},
                {3, 2, 1, -1},
                {1, 1, 1, -2},
                {1, 1, -1, -2},
                {-1, -1, -2, -3},
        };
        int count = countNegatives(matrix);
        System.out.println(count);
    }

    private static int countNegatives(int[][] grid) {
        int count = 0;
        int low = 0, high = 0;
        for (int i = grid.length - 1; i >= 0; i--) {
            low = 0;
            high = grid[i].length - 1;
            if (grid[i][high] > 0) continue;
            if (grid[i][low] < 0) {
                count += grid[i].length;
                continue;
            }
            for (int j = high; grid[i][high] < 0; j--) {
                count++;
                high--;
            }
        }
        return count;
    }
}
