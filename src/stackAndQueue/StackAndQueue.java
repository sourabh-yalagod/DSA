package stackAndQueue;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class StackAndQueue {
    public static void main(String[] args) {
        String paras = "{{([])}}";
//        System.out.print(isValid(paras));

        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
//        nextGreaterElement2(nums2);
        int[] rectangle = {1, 2, 5, 6, 2, 3};
        largestRectangleArea(rectangle);
    }

    public static boolean isValid(String para) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < para.length(); i++) {
            if (para.charAt(i) == '{') stack.push('}');
            else if (para.charAt(i) == '[') stack.push(']');
            else if (para.charAt(i) == '(') stack.push(')');
            else {
                if (stack.isEmpty()) return false;
                if (!stack.peek().equals(para.charAt(i))) return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public static int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                stack.pop();
            }
            int nextGraterValue = stack.isEmpty() ? -1 : stack.peek();
            map.put(nums2[i], nextGraterValue);
            stack.push(nums2[i]);
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = map.get(nums1[i]);
            System.out.print(" " + nums1[i]);
        }
        return nums1;
    }

    public static int[] nextGreaterElement2(int[] num) {
        int len = num.length;

        Stack<Integer> stack = new Stack<>();
        int[] result = new int[num.length];
        for (int i = (num.length * 2) - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= num[i % len]) {
                stack.pop();
            }
            result[i % len] = stack.isEmpty() ? -1 : stack.peek();

            stack.push(num[i % len]);
        }
        for (int i = 0; i < result.length; i++) {
            System.out.print(" " + result[i]);
        }
        return result;
    }

    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int length = heights.length;
        int[] nextSmallElements = new int[length];
        int[] previousSmallElements = new int[length];
        int sum = 0;
        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) stack.pop();
            previousSmallElements[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        stack.clear();
        for (int i = length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) stack.pop();
            nextSmallElements[i] = stack.isEmpty() ? length - 1 : stack.peek();
            stack.push(i);
        }
        for (int i = 0; i < length; i++) {
            System.out.print(heights[i] + ". ");
            System.out.print(previousSmallElements[i] + " ");
            System.out.print(nextSmallElements[i] + " ");
            System.out.print(" - " + heights[i] * (nextSmallElements[i] - previousSmallElements[i] + 1));
            System.out.println();
//            int area = heights[i] * (nextSmallElements[i] - previousSmallElements[i]);
//            maxArea = Math.max(maxArea, area);
        }
        return sum;
    }
}
