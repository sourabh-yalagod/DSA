package string;

public class DecodeWays {
    public static void main(String[] args) {
        String str = "12";
        System.out.println(countWays(str));
    }

    public static int countWays(String str) {
        if (str == null || str.isEmpty()) return 0;
        if (str.charAt(0) == '0') return 0;
        int index = 0;
        int count = 0;
        boolean isFirstDigit = false;
        while (index < str.length()) {
            int firstDigit = 'A' + Integer.parseInt(str.substring(index, index + 1)) - 1;
            if (firstDigit >= 65 && firstDigit <= 90) {
                isFirstDigit = true;
            }
            index++;

        }
        if (isFirstDigit) {
            count++;
            isFirstDigit = false;
        }
        index = 0;
        while (index < str.length()) {
            if (str.length() < 2 || (index + 2) > str.length()) return count;
            int firstDigit = 'A' + Integer.parseInt(str.substring(index, index + 2)) - 1;
            if (firstDigit >= 65 && firstDigit <= 90) {
                isFirstDigit = true;
            }
            index++;
        }
        if (isFirstDigit) {
            count++;
        }
        return count;
    }

}
