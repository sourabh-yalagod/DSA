package Neetcode_150;

import java.util.HashSet;
import java.util.Set;

public class LongetsSubstring {
    public static void main(String[] args) {
        String str = "abcabcbb";
        int count = countLongestSubString(str);
        System.out.println(count);
    }

    private static int countLongestSubString(String str) {
        int maxCount = 0;
        int left = 0;
        int right = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            if (set.contains(str.charAt(i))) {
                left++;
            } else {
                set.add(str.charAt(i));
                right++;
            }
            maxCount = Math.max(right - left + 1, maxCount);
        }
        return maxCount;
    }

}
