package neetCode150.ArrayAndHashMaps;

import java.util.*;

public class Solutions {
    public static void main(String[] args) {
        int[] array = {1, 2, 2, 4, 5};
        String[] strings = {"act", "act", "bus", "train", "sub"};
        System.out.println(groupAnagrams(strings));
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

    private static List<List<String>> groupAnagrams(String[] strings) {
        Map<String, List<String>> tempMap = new HashMap<>();
        for (int i = 0; i < strings.length; i++) {
            char[] chars = strings[i].toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            tempMap.computeIfAbsent(key, (k) -> new ArrayList<String>())
                    .add(strings[i]);
        }
        return new ArrayList<>(tempMap.values());
    }
}
