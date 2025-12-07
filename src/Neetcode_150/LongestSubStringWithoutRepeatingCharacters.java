package Neetcode_150;

import java.util.HashSet;
import java.util.Set;

public class LongestSubStringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String str = "abcabccc";
        int count = findLongestSubStringWithoutRepeatingCharacter(str);
        System.out.println(count);
    }

    private static int findLongestSubStringWithoutRepeatingCharacter(String str) {
        int count = 0;
        int left = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            while (set.contains(str.charAt(i))) {
                set.remove(str.charAt(left));
                left++;
            }
            set.add(str.charAt(i));
            count = Math.max(count, i - left + 1);
        }
        return count;
    }

    public static int bruteForce(String str) {
        int maxCount = 0;
        for (int i = 0; i < str.length(); i++) {
            int count = 1;
            char ch = str.charAt(i);
            for (int j = i; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j) && i != j) {
                    break;
                } else {
                    count++;
                }
            }
            System.out.println();
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
}
