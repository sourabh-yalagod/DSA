class Solution {
    public int myAtoi(String s) {
        int i = 0;
        int length = s.length();
        int symbol = 1;

        // 1. Skip spaces
        while (i < length && s.charAt(i) == ' ') {
            i++;
        }

        // 2. Handle sign (+ and -)
        if (i < length && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            symbol = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        // 3. Build number safely (NO StringBuilder now)
        int result = 0;

        while (i < length) {
            char ch = s.charAt(i);

            if (!Character.isDigit(ch)) break;

            int digit = ch - '0';

            // 4. Overflow check
            if (result > (Integer.MAX_VALUE - digit) / 10) {
                return symbol == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            i++;
        }

        return result * symbol;
    }
}