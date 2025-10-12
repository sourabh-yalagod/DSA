package arrays;

import java.util.*;

public class NextLargeElement {
    public static void main(String[] args) {
        int[] array1 = {12, 56, 34, 89, 10};
        int[] array2 = {12, 56, 34, 2, 3, 78, 89, 10};
        int[] list = findNextLargeInteger(array1, array2);
        for (int i = 0; i < list.length; i++) {
            System.out.print(" " + list[i]);
        }
    }

    private static int[] findNextLargeInteger(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        int index = nums2.length - 1;
        while (index >= 0) {
            while (!stack.empty() && nums2[index] > stack.peek()) {
                stack.pop();
            }
            if (!stack.empty()) {
                map.put(nums2[index], stack.peek());
                list.add(stack.peek());
            } else {
                map.put(nums2[index], -1);
                list.add(-1);
            }
            stack.push(nums2[index]);
            index--;
        }
        System.out.println(map);
        int[] result = new int[nums1.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = map.get(nums1[i]);
        }
        return result;
    }
}
