package DSA_250;

import java.util.HashMap;
import java.util.Map;

public class ArrayEasy {
    public static void main(String[] args) {
        int[] array = {9, 0, 9, 12, 1, 23, 4, 4, 5};
        int count = minSubArrayLen(31, array);
        System.out.println(count);
    }

    private static int[] twoSum(int[] array, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = {-1, -1};
        for (int i = 0; i < array.length; i++) {
            int remaining = target - array[i];
            if (map.containsKey(remaining)) {
                result[0] = map.get(remaining);
                result[1] = i;
                System.out.println(result[0]);
                System.out.println(result[1]);
                return result;
            }
            map.put(array[i], i);
        }
        return result;
    }

    private static int removeDuplicatesFromSortedArray(int[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (i == 0 || array[i] != array[i - 1]) {
                array[count++] = array[i];
            }
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(" " + array[i]);
        }
        System.out.println();
        return count;
    }

    private static int[] plusOne(int[] digits) {
        int value = 0;
        for (int i = 0; i < digits.length; i++) {
            value = value * 10 + digits[i];
        }
        value += 1;
        System.out.println(value);
        if (digits[0] == 9 & digits[digits.length - 1] == 9) {
            int[] result = new int[digits.length + 1];
            int index = result.length - 1;
            while (value > 0) {
                result[index--] = value % 10;
                value /= 10;
            }
            return result;
        }
        int index = digits.length - 1;
        while (value > 0) {
            digits[index--] = value % 10;
            value /= 10;
        }
        return digits;
    }

    private static void inPlaceSwap(int[] array) {
        int slow = 0;
        for (int fast = 0; fast < array.length; fast++) {
            if (array[fast] != 0) {
                array[slow++] = array[fast];
            }
        }
        while (slow < array.length) {
            array[slow++] = 0;
        }
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int window = Integer.MAX_VALUE;
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            System.out.println("Sum : " + sum + " Left : " + left + " Right : " + i);
            while (sum >= target) {
                window = Math.min(window, i - left + 1);
                sum -= nums[left++];
            }
        }
        return window == Integer.MAX_VALUE ? 0 : window;
    }
}
