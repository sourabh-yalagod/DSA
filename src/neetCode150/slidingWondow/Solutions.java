package neetCode150.slidingWondow;

import java.util.*;

public class Solutions {
    public static void main(String[] args) {
        System.out.println(minWindowSubString("rabh", "soaurawwwbh"));
    }

    private static int bestTimeToBuyStock1(int[] prices) {
        int maxProfit = 0;
        int low = 0;
        int high = prices.length - 1;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < prices[low]) {
                low = i;
                high = i;
            }
            if (prices[i] > prices[high]) {
                high = i;
            }
            maxProfit = Math.max(maxProfit, prices[high] - prices[low]);
        }
        return maxProfit;
    }

    private static int bestTimeToBuyStock2(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += (prices[i] - prices[i - 1]);
            }
        }
        return maxProfit;
    }

    private static int bestTimeToBuyStock3(int[] prices) {
        List<List<Integer>> list = new ArrayList<>();
        int low = 0;
        int high = 0;
        int[] maxProfit = {0, 0};
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] <= prices[low]) {
                if (low != 0 || high != 0) {
                    list.add(List.of(low, high));
                }
                low = i;
                high = i;
            }
            if (prices[i] > prices[high]) {
                high = i;
            }
        }
        list.add(List.of(low, high));
        list.forEach(arr -> {
            int profit = prices[arr.get(1)] - prices[arr.get(0)];
            if (maxProfit[0] < profit) {
                maxProfit[1] = maxProfit[0];
                maxProfit[0] = profit;
            } else if (maxProfit[1] < profit) {
                maxProfit[1] = profit;
            }
        });
        return maxProfit[0] + maxProfit[1];
    }

    private static int longestSubstringWithoutRepeatingCharacter(String string) {
        Set<Character> set = new HashSet<>();
        int left = 0;
        int right = 0;
        int len = 0;
        while (right < string.length()) {
            char ch = string.charAt(right);
            while (set.contains(string.charAt(right))) {
                set.remove(string.charAt(left++));
            }
            right++;
            set.add(ch);
            len = Math.max(len, right - left);
        }
        return len;
    }

    private static int longestRepeatingCharacterReplacement(String string, int k) {
        int count = 0;
        Map<Character, Integer> map = new HashMap<>();
        int low = 0;
        int high = 0;
        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(high);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            while ((high - low + 1) - map.get(ch) > k) {
                char leftChar = string.charAt(low++);
                map.put(leftChar, map.getOrDefault(leftChar, 0) - 1);
            }
            count = Math.max(count, high - low + 1);
            high++;
        }
        return count;
    }

    private static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] hashTable1 = new int[26];
        int[] hashTable2 = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            hashTable1[s1.charAt(i) - 'a']++;
        }

        int window = s1.length();

        for (int i = 0; i < window; i++) {
            hashTable2[s2.charAt(i) - 'a']++;
        }

        if (matched(hashTable1, hashTable2)) return true;

        int left = 0;
        int right = window;

        while (right < s2.length()) {
            hashTable2[s2.charAt(left++) - 'a']--;
            hashTable2[s2.charAt(right++) - 'a']++;
            if (matched(hashTable1, hashTable2)) return true;
        }

        return false;
    }

    private static boolean matched(int[] hashTable1, int[] hashTable2) {
        for (int i = 0; i < 26; i++) {
            if (hashTable1[i] != hashTable2[i]) return false;
        }
        return true;
    }

    private static boolean matched2(Map<Character, Integer> map1, Map<Character, Integer> map2) {
        for (char ch : map1.keySet()) {
            if (map1.get(ch) > map2.getOrDefault(ch, 0)) return false;
        }
        return true;
    }

    private static String minWindowSubString(String s1, String s2) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (char ch : s1.toCharArray()) {
            map1.put(ch, map1.getOrDefault(ch, 0) + 1);
        }
        int right = 0;
        for (char ch : s2.toCharArray()) {
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);
            right++;
            if (matched2(map1, map2)) break;
        }
        if (!matched2(map1, map2)) return "";
        int left = 0;
        while (left < right) {
            char ch = s2.charAt(left);
            map2.put(ch, map2.get(ch) - 1);
            if (matched2(map1, map2)) left++;
            else break;
        }
        return s2.substring(left, right);
    }
}
