package string;

import java.util.*;

public class Solutions {

    public static void main(String[] args) {
        System.out.println(longestBalanced("abbac"));
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

    private static String smallestString(String s1, String s2) {
        int s1Len = s1.length();
        int s2Len = s2.length();
        if (s2Len > s1Len) return "";
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (char ch : s1.toCharArray()) {
            map1.put(ch, map1.getOrDefault(ch, 0) + 1);
        }
        for (char ch : s2.toCharArray()) {
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);
        }
        // ability -> lait
        int left = 0;
        int right = s2.length() - 1;
        for (int i = 0; i < s1.length(); i++) {
            char leftChar = s1.charAt(i);
            int have = map1.getOrDefault(leftChar, 0);
            int need = map2.getOrDefault(leftChar, 0);
            if (have > need) {
                map1.put(leftChar, have - 1);
                left++;
            }
            char rightChar = s1.charAt(s1Len - i - 1);
            int have1 = map1.getOrDefault(rightChar, 0);
            int need1 = map2.getOrDefault(rightChar, 0);
            if (have1 > need1) {
                map1.put(rightChar, have - 1);
                right--;
            }
        }
        System.out.println(left + " - " + right);
        return s1.substring(left, right + 1);
    }

    private static int longestSubStringWithUnique(String str) {
        int left = 0;
        int right = 0;
        int max = 0;
        Set<Character> set = new HashSet<>();
        while (right < str.length()) {
            char ch = str.charAt(right++);
            while (set.contains(ch)) {
                set.remove(str.charAt(left++));
            }
            set.add(ch);
            max = Math.max(max, right - left);
        }
        return max;
    }

    private static int longestSubStringWithKElements(String str, int k) {
        int left = 0;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int right = 0; right < str.length(); right++) {
            char ch = str.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            int frequency = map.getOrDefault(ch, 0);
            while ((right - left + 1 - frequency) > k) {
                char leftChar = str.charAt(left++);
                map.put(leftChar, map.getOrDefault(leftChar, 0));
            }
            max = Math.max(max, right - left);
        }
        return max;
    }

    public static int longestBalanced(String s) {
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            int[] map = new int[26];
            for (int j = i + 1; j < s.length(); j++) {
                int index = s.charAt(j) - 'a';
                map[index]++;
                int sum = 0;
                for (int k : map) {
                    if (k != 0 && map[k] != index) sum = 1;
                }
                if (sum == 0) max = Math.max(max, j - i + 1);
            }
        }
        return max;
    }
}
