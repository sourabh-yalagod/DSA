package string;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String str = "bcabcac";
        String str1 = longestPalindrome(str);
        System.out.println("Result : " + str1);
    }

    private static String longestPalindrome(String str) {
        int low = 0;
        int high = 0;
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            low = i - 1;
            high = i + 1;
            while (low >= 0 && high < str.length() && str.charAt(low) == str.charAt(high)) {
                if (result.length() < (high - low + 1)) {
                    result = str.substring(low, high + 1);
                }
                low--;
                high++;
            }
            low = i;
            high = i + 1;
            while (low >= 0 && high < str.length() && str.charAt(low) == str.charAt(high)) {
                if (result.length() < (high - low + 1)) {
                    result = str.substring(low, high + 1);
                }
                low--;
                high++;
            }
        }
        return !result.isEmpty() ? str.substring(0, 2) : result;
    }
}
