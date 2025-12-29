package neetCode150.ArrayAndHashMaps;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solutions {
    public static void main(String[] args) {
        int[] array = {1, 2, 2, 4, 5};
        System.out.println(validAnagram("caat", "aact"));
    }

    private static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) return true;
            else set.add(nums[i]);
        }
        return false;
    }

    private static boolean validAnagram(String str1, String str2) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : str1.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (char ch : str2.toCharArray()) {
            if (!map.containsKey(ch)) return false;
            int count = map.get(ch);
            if (count == 1) map.remove(ch);
            else map.put(ch, count - 1);
        }
        return map.isEmpty();
    }
}
