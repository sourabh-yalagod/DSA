package two_pointer;

public class ReverseInteger {
    public static void main(String[] args) {
        int num = -1223233;
        int reversedNumber = reverse(num);
        System.out.println(reversedNumber);
    }

    private static int reverse(int num) {
        long reversed = 0;
        boolean isNegative = false;
        if (num < 0) {
            num = -1 * num;
            isNegative = true;
        }
        while (num > 0) {
            int digit = num % 10;
            reversed = reversed * 10 + digit;
            if (reversed > Integer.MAX_VALUE) return 0;
            num /= 10;
        }
        reversed = isNegative ? (-1 * reversed) : reversed;
        return (int) reversed;
    }
}
