package Neetcode_150;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        int k = 1;
        String str = "ABBB";
        int count = findLongestSubString(str, k);
        System.out.println(count);
    }

    private static int findLongestSubString(String str, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, count = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            while ((i - left) - map.get(ch) < k) {
                map.put(str.charAt(left), map.get(str.charAt(left)) - 1);
                left++;
            }
        }
        System.out.println(map);
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
