package patterProgramming;

public class Pattern {
    public static void main(String[] args) {
        slop(5);
//        border(5, 5);
    }

    public static void K(int row) {
        for (int i = 1; i <= row * 2; i++) {
            int index = i;
            for (int j = index; j <= row; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void rectangle(int row, int col) {
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }


    public static void border(int row, int col) {
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (i == 1 || j == 1 || i == row || j == col) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void slop(int row) {
        for (int i = row; i >= 1; i--) {
            for (int j = i; j <= row; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
