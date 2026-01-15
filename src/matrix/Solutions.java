package matrix;

public class Solutions {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        spiralMatrix(matrix);
    }

    private static void spiralMatrix(int[][] matrix) {
        int left = 0;
        int right = matrix[0].length - 1;
        int bottom = matrix.length - 1;
        int top = 0;
        int count = (right + 1) * (left + 1);
        while (count > 0) {
            for (int i = top; i <= right; i++) {
                count--;
                System.out.print(" " + matrix[top][i]);
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                count--;
                System.out.print(" " + matrix[i][bottom]);
            }
            right--;
            for (int i = right; i >= left; i--) {
                count--;
                System.out.print(" " + matrix[bottom][i]);
            }
            bottom--;
            for (int i = bottom; i >= top; i--) {
                count--;
                System.out.print(" " + matrix[top][i]);
            }
        }
    }
}
