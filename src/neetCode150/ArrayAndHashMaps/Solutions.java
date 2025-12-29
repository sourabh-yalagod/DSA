package neetCode150.ArrayAndHashMaps;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solutions {
    public static void main(String[] args) {
        int[] array = {1, 2, 2, 4, 5};
        System.out.println(twoSum(array,6));
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

    private static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int remaining = target - nums[i];
            if (map.containsKey(nums[i])) {
                System.out.println(map.get(nums[i]) + " " + i);
                return new int[]{map.get(nums[i]), i};
            }
            map.put(remaining, i);
        }
        return new int[]{-1, -1};
    }
}
