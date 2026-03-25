class Solution {
    public int longestValidParentheses(String s) {
        int open = 0;
        int close = 0;
        int max = 0;

        // Left → Right
        for (char ch : s.toCharArray()) {
            if (ch == '(') open++;
            else close++;

            if (open == close) {
                max = Math.max(max, 2 * close);
            } else if (close > open) {
                open = 0;
                close = 0;
            }
        }

        // Reset
        open = 0;
        close = 0;

        // Right → Left
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);

            if (ch == ')') close++;
            else open++;

            if (open == close) {
                max = Math.max(max, 2 * open);
            } else if (open > close) {
                open = 0;
                close = 0;
            }
        }

        return max;
    }
}