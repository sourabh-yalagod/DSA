package string;

import java.util.*;

public class Solutions {
    public static void main(String[] args) {
        String str = "Hello world my name is Sourabh";
        System.out.println(reverseWords(str));
    }

    private static String reverseWords(String str) {
        char[] chars = str.toCharArray();
        int left = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                reverse(chars, left, i - 1);
                left = i + 1;
            }
        }
        reverse(chars, left, str.length() - 1);
        return new String(chars);
    }

    private static void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }

    private static String longestWord(String str) {
        String result = "";
        int count = 0;
        int maxCount = 0;
        int left = 0;
        int right = 0;
        for (char ch : str.toCharArray()) {
            if (ch == ' ') {
                if (count >= maxCount) {
                    result = str.substring(left, right + 1);
                    maxCount = count;
                }
                System.out.println(count);
                count = 0;
                left = ++right;
            } else {
                right++;
                count++;
            }
        }
        if (result.length() < (right - left))
            result = str.substring(left, right);
        return result.trim();
    }

    private static char findDuplicate(String str) {
        Set<Character> set = new HashSet<>();
        for (char ch : str.toCharArray()) {
            if (set.contains(ch)) {
                return ch;
            } else set.add(ch);
        }
        return ' ';
    }

    private static List<Character> uniqueCharacter(String str) {
        Map<Character, Integer> map = new HashMap<>();
        List<Character> result = new ArrayList<>();
        for (char ch : str.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        map.forEach((key, value) -> {
            if (map.get(key) == 1) {
                result.add(key);
            }
        });
        return result;
    }
}
