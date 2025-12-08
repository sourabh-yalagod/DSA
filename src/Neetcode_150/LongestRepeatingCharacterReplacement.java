package Neetcode_150;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        int k = 2;
        String str = "ababbbaa";
        int count = findLongestSubString(str, k);
        System.out.println(count);
    }

    private static int findLongestSubString(String str, int k) {
        int left = 0;
        int count = 0;
        int maxFreq = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(ch));
            while ((i - left + 1) - maxFreq > k) {
                char leftChar = str.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) <= 0) map.remove(leftChar);
                left++;
            }
            count = Math.max(count, i - left + 1);
        }
        return count;
    }


    public static int bruteForce(String str, int k) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int tempK = k;
            int innerCount = 1;
            for (int j = i; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j) && i != j) {
                    innerCount++;
                } else if (tempK != 0) {
                    tempK--;
                    innerCount++;
                } else break;
            }
            count = Math.max(innerCount, count);
        }
        return count;
    }
}
