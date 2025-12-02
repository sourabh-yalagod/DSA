package Neetcode_150;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int target = 13;
        int[] result = twoSum2(arr, target);
    }

    private static int[] twoSum1(int[] arr, int target) {
        int[] result = {-1, -1};
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int difference = target - arr[i];
            if (map.containsKey(arr[i])) {
                result[0] = map.get(arr[i]);
                result[1] = i;
                return result;
            }
            map.put(difference, i);
        }
        return result;
    }

    private static int[] twoSum2(int[] arr, int target) {
        int[] result = {-1, -1};
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int currentSum = arr[left] + arr[right];
            if (currentSum == target) {
                result[0] = left;
                result[1] = right;
                System.out.println(left + " " + right);
                return result;
            } else if (target < currentSum) right--;
            else left++;
        }
        return result;
    }

}
