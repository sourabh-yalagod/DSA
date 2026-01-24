package neetCode150.ArrayAndHashMaps;

import java.util.*;

public class Solutions {
    public static void main(String[] args) {
        int[] array = {1, 3, 5, 2, 2};

        System.out.println(find(array));
    }

    private static int[] rotateArray(int[] array, int n) {
        int len = array.length;
        reverse(array, 0, len - 1);
        reverse(array, 0, n - 1);
        reverse(array, n, len - 1);
        return array;
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
            tempMap.computeIfAbsent(key, (k) -> new ArrayList<String>()).add(strings[i]);
        }
        return new ArrayList<>(tempMap.values());
    }

    private static List<Integer> topKElements(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> freq = new ArrayList<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            freq.add(new ArrayList<>());
        }
        map.forEach((key, value) -> {
            freq.get(value).add(key);
        });
        for (int i = freq.size() - 1; i >= 0; i--) {
            if (freq.get(i).isEmpty()) continue;
            if (k <= 0) break;
            System.out.println("freq.get(i) : " + freq.get(i));
            list.addAll(freq.get(i));
            k -= freq.get(i).size();
        }
        return list;
    }

    private static String encode(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder innerResult = new StringBuilder();
        for (char ch : string.toCharArray()) {
            if (ch == ' ') {
                int len = innerResult.length();
                stringBuilder.append(Integer.toString(len));
                stringBuilder.append(innerResult.toString());
                innerResult.delete(0, len);
            } else innerResult.append(ch);
        }
        stringBuilder.append(innerResult.length());
        stringBuilder.append(innerResult.toString());
        return stringBuilder.toString();
    }

    private static String decode(String string) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            if (Character.isDigit(string.charAt(i))) {
                int len = string.charAt(i) - '0';
                for (int j = i + 1; j <= len + i; j++) {
                    result.append(string.charAt(j));
                }
                i += len;
                if (i < string.length() - 1) result.append(" ");
            }
        }
        return result.toString();
    }

    private static int[] productOfArrayExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        int[] prefix = new int[nums.length];
        int[] postfix = new int[nums.length];
        prefix[0] = 1;
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }
        int n = prefix.length;
        postfix[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            postfix[i] = postfix[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < nums.length; i++) {
            result[i] = prefix[i] * postfix[i];
        }
        return result;
    }

    private static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int count = 0;
        for (int num : nums) {
            set.add(num);
        }
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int innerCount = 1;
                int currentNum = num;
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    innerCount++;
                }
                count = Math.max(count, innerCount);
            }
        }
        return count;
    }

    private static int[] mergeSortedArray(int[] array1, int[] array2) {
        int first = array1.length - 1;
        int second = array2.length - 1;
        int last = first;
        for (int i = array1.length - 1; i >= 0; i--) {
            if (array1[i] != 0) break;
            first--;
        }
        while (first >= 0 && second >= 0) {
            if (array1[first] < array2[second]) {
                array1[last--] = array2[second--];
            } else {
                array1[last--] = array1[first--];
            }
        }
        while (second >= 0) {
            array1[last--] = array2[second--];
        }
        return array1;
    }

    private static void reverse(int[] array, int low, int high) {
        while (low < high) {
            int temp = array[low];
            array[low] = array[high];
            array[high] = temp;
            low++;
            high--;
        }
    }

    private static int find(int[] array) {
        int sum = 0;
        int[] left = new int[array.length];
        int[] right = new int[array.length];
        for (int i = 1; i < array.length; i++) {
            sum += array[i - 1];
            left[i] = sum;
        }
        sum = 0;
        for (int i = array.length - 2; i >= 0; i--) {
            sum += array[i + 1];
            right[i] = sum;
        }
        for (int i = 0; i < array.length; i++) {
            if (left[i] == right[i]) return i;
        }
        return -1;
    }
}
