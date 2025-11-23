package string;

public class StringToInteger {
    public static void main(String[] args) {
        String str = "-112345iu44322345678a00a";
        int number = myAtoi(str);
        System.out.println(number);
    }

    private static int myAtoi(String s) {
        s = s.trim();
        if (s.isEmpty()) return 0;
        int i = 0;
        int length = s.length();
        int sign = 1;
        long result = 0;
        while (i < length && s.charAt(i) == ' ') i++;

        if (s.charAt(i) == '+') {
            sign = +1;
            i++;
        } else if (s.charAt(i) == '-') {
            sign = -1;
            i++;
        }

        while (i < length && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';
            result = result * 10 + digit;
            if (sign == 1 && result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE * sign;
            }
            if (sign == -1 && -result < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE * sign;
            }
            i++;
        }
        return (int) result * sign;
    }
}
