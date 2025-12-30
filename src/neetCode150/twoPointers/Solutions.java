package neetCode150.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solutions {
    public static void main(String[] args) {
        int[] array = {4, 2, 0, 3, 2, 5};
        System.out.println(trappingRainWater(array));
    }

    private static boolean validPalindrome(String string) {
        int left = 0;
        int right = string.length() - 1;
        while (left < right) {
            if (string.charAt(left) != string.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    private static int[] twoSum2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] == target) return new int[]{left, right};
            else if (nums[left] + nums[right] > target) right--;
            else left++;
        }
        return new int[]{-1, -1};
    }

    private static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 1; i < nums.length - 2; i++) {
            int left = 0;
            int right = nums.length - 1;
            while (i < right && nums[i] == nums[i + 1]) i++;
            while (left < right) {
                if (left == i) left++;
                if (right == i) right--;
                int sum = nums[left] + nums[right] + nums[i];
                if (sum == 0) list.add(List.of(nums[left++], nums[i], nums[right--]));
                else if (sum > 0) right--;
                else left++;
            }
        }
        return list;
    }

}
