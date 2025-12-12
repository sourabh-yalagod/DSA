package Neetcode_150;

public class StringProblems {
    public static void main(String[] args) {
        System.out.println(reverseStr("abcdefg", 8));
    }

    public static String reverseStr(String s, int k) {
        if (s.isEmpty() || k == 0) return s;
        int len = s.length();
        int index = 0;
        char[] chars = s.toCharArray();
        int left = 0;
        int right = index;
        while (index < len) {
            if (len <= k) {
                swap(chars, left, s.length() - 1);
                break;
            }
            if ((index + 1) % k == 0) {
                right = index;
                swap(chars, left, right);
                index += k;
                left = index + 1;
            }
            index++;
        }
        return new String(chars);
    }

    public static void swap(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }
}
