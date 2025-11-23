package string;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        String str = "pwwkew";
        System.out.println(lengthOfLongestSubstring(str));
    }

    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        int innerMax = 0;
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                innerMax = 0;
                map.clear();
                map.put(s.charAt(i),s.charAt(i));
            } else {
                map.put(s.charAt(i), s.charAt(i));
                innerMax++;
            }
            max = Math.max(innerMax, max);
        }
        return max;
    }
}
