package neetCode150.twoPointers;

public class Solutions {
    public static void main(String[] args) {
        System.out.println(validPalindrome("ca"));
    }

    private static boolean validPalindrome(String string) {
        int left = 0;
        int right = string.length() - 1;
        while (left < right) {
            if (string.charAt(left) != string.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
