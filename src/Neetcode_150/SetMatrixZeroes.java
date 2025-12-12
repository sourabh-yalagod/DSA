package Neetcode_150;

public class SetMatrixZeroes {
    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 1},
                {2, 2, 9},
                {1, 1, 2},
                {1, 2, 2}
        };
        int[][] matrix1 = optimalApproach(matrix);
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[i].length; j++) {
                System.out.print(matrix1[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] optimalApproach(int[][] matrix) {
        int cols = matrix.length;
        int rows = matrix[0].length;
        boolean isZeroInFirstRow = false;
        boolean isZeroInFirstColumn = false;
        // check 0 exist in first column OR row
        for (int i = 0; i < rows; i++) {
            if (matrix[0][i] == 0) {
                isZeroInFirstRow = true;
                break;
            }
        }
        for (int i = 0; i < cols; i++) {
            if (matrix[i][0] == 0) {
                isZeroInFirstColumn = true;
                break;
            }
        }
        for (int i = 1; i < cols; i++) {
            for (int j = 1; j < rows; j++) {
                if (matrix[i][j] == 0) {
                    matrix[j][0] = 0;
                    matrix[0][i] = 0;
                }
            }
        }
        for (int i = 1; i < cols; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < rows; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 1; i < rows; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 1; j < cols; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        if (isZeroInFirstColumn) {
            for (int i = 0; i < cols; i++) {
                matrix[i][0] = 0;
            }
        }
        if (isZeroInFirstRow) {
            for (int i = 0; i < rows; i++) {
                matrix[0][i] = 0;
            }
        }
        return matrix;
    }
}
