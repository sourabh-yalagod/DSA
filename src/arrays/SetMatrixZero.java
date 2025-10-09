package arrays;

public class SetMatrixZero {
    public static void main(String[] args) {
        int[][] matrix = {{1, 1, 7, 1}, {0, 0, 1, 3}, {4, 5, 3, 2}, {7, 6, 1, 2}};
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(" " + matrix[i][j]);
            }
            System.out.println();
        }
        int[][] matrixWithZeros = setMatrixZero(matrix);
        System.out.println("Matrix with Zeros");
        for (int i = 0; i < matrixWithZeros.length; i++) {
            for (int j = 0; j < matrixWithZeros[i].length; j++) {
                System.out.print(" " + matrixWithZeros[i][j]);
            }
            System.out.println();
        }
    }

    private static int[][] setMatrixZero(int[][] matrix) {
        boolean isFirstRowHaveZero = false, isFirstColumnHaveZero = false;
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                isFirstRowHaveZero = true;
                break;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                isFirstColumnHaveZero = true;
                break;
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        // set rows zero based on first column values
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        // set column 0 based on first row vlaues
        for (int i = 1; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 0; j < matrix.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        // set entire row zero if isFirstRowHaveZero if true
        if (isFirstRowHaveZero) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }
        // set entire first column zero if isFirstColumnHaveZero is zero
        if (isFirstColumnHaveZero) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
        return matrix;
    }
}
