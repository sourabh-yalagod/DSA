package pattern;

public class Solutions {
    public static void main(String[] args) {
        tringle(5);
        invertTrangle(5);
    }

    private static void slidingTringle(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    private static void slidingInvertTringle(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = n; j >= i; j--) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    private static void tringle(int n) {
        n = n * 2;
        int mid = n / 2;
        int left = mid;
        int right = mid;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= mid; j++) {
                if (left <= j && right >= j) System.out.print("* ");
                else System.out.print(" ");
            }
            System.out.println();
            left--;
            right++;
            if (left <= 0 && right >= mid) break;
        }
    }

    private static void invertTrangle(int n) {
        n = n * 2;
        int mid = n / 2;
        int left = 0;
        int right = n - 1;
        for (int i = 0; i < mid; i++) {
            for (int j = 0; j < mid; j++) {
                if (j >= left && j <= right) System.out.print("* ");
                else System.out.print(" ");
            }
            System.out.println();
            left++;
            right--;
            if (left == mid && right == 0) break;
        }
    }
}
