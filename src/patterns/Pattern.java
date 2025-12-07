package patterns;

public class Pattern {
    public static void main(String[] args) {
        trangle(5);
    }

    public static void rightTrangle(int row) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < row; j++) {
                if (i + j + 1 >= row) System.out.print("* ");
                else System.out.print("  ");
            }
            System.out.println();
        }
    }

    public static void trangle(int row) {
        int left = row / 2;
        int right = row / 2;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < row * 2; j++) {
                if (j >= left && j <= right) {
                    System.out.print("*");
                } else System.out.print(" ");
            }
            left--;
            right++;
            System.out.println();
        }
    }

    public static void crossDiagonal(int row) {
        for (int i = row; i >= 0; i--) {
            for (int j = row; j >= 0; j--) {
                if (i + j == row) {
                    System.out.print("* ");
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void cross(int row) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < row; j++) {
                if ((i + j == row - 1) || i == j) {
                    System.out.print("*");
                } else System.out.print(" ");
            }
            System.out.println();
        }
    }
}
