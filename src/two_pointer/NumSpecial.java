package two_pointer;

public class NumSpecial {
    public static void main(String[] args) {
        int[][] mat = {
                {0, 0, 0, 1},
                {1, 0, 0, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0}
        };
        int count = numSpecial(mat);
        System.out.println(count);
    }

    private static int numSpecial(int[][] mat) {
        int count = 0;
        int row[] = new int[mat[0].length];
        int column[] = new int[mat.length];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    row[i] += 1;
                    column[j] += 1;
                }
            }
        }
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    if (row[i] == 1 && column[j] == 1) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
