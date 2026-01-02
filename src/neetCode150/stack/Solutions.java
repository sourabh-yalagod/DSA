package neetCode150.stack;

import java.util.Arrays;
import java.util.Objects;
import java.util.Stack;

public class Solutions {
    public static void main(String[] args) {
        int[] array = {7, 1, 7, 2, 2, 4};
        System.out.println(largeHistogram(array));
    }

    private static boolean validParentheses(String para) {
        if (para.isEmpty()) return true;
        Stack<Character> stack = new Stack<>();
        for (char ch : para.toCharArray()) {
            if (ch == '(') stack.add(')');
            else if (ch == '[') stack.add(']');
            else if (ch == '{') stack.add('}');
            else {
                if (stack.isEmpty()) return false;
                if (stack.pop() != ch) return false;
            }
        }
        return stack.isEmpty();
    }

    class MinStack {
        private static Stack<Integer> minStack = new Stack<>();
        private static Stack<Integer> stack = new Stack<>();

        public MinStack() {

        }

        public static void push(int val) {
            if (minStack.isEmpty() && stack.isEmpty()) {
                minStack.push(val);
                stack.push(val);
            }
            if (minStack.peek() > val) minStack.push(val);
            stack.push(val);
        }

        public static void pop() {
            if (Objects.equals(stack.pop(), minStack.peek())) minStack.pop();
        }

        public static int top() {
            return stack.peek();
        }

        public static int getMin() {
            return minStack.peek();
        }
    }

    private static int polishFlagCompute(String[] strings) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        for (String string : strings) {
            if (isSymbol(string)) {
                int first = stack.pop();
                int second = stack.pop();
                switch (string) {
                    case "+":
                        result = first + second;
                        break;
                    case "-":
                        result = second - first;
                        break;
                    case "*":
                        result = second * first;
                        break;
                    case "/":
                        result = second / first;
                        break;
                }
                stack.push(result);
            } else stack.push(Integer.parseInt(string));
        }
        return result;
    }

    private static boolean isSymbol(String symbol) {
        return symbol.equals("+") || symbol.equals("/") || symbol.equals("*") || symbol.equals("-");
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[temperatures.length];
        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) stack.pop();
            result[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return result;
    }

    private static int carFleets(int target, int[] position, int[] speed) {
        int[][] matrix = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            matrix[i][0] = position[i];
            matrix[i][1] = speed[i];
        }
        Arrays.sort(matrix, (a, b) -> b[0] - a[0]);
        int[] remaining = new int[position.length];
        for (int i = 0; i < position.length; i++) {
            remaining[i] = (target - matrix[i][0]) / matrix[i][1];
        }
        int fleets = 0;
        double maxTime = 0;
        for (int i = 0; i < matrix.length; i++) {
            double time = (double) (target - matrix[i][0]) / matrix[i][1];
            if (time > maxTime) {
                fleets++;
                maxTime = time;
            }
        }
        return fleets;
    }

    private static int largeHistogram(int[] height) {
        int area = 0;
        int length = height.length;
        int[] nextSmallerElements = new int[length];
        int[] previousSmallerElements = new int[length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] >= height[i]) stack.pop();
            previousSmallerElements[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        stack.clear();
        for (int i = length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && height[stack.peek()] >= height[i]) stack.pop();
            nextSmallerElements[i] = stack.isEmpty() ? length : stack.peek();
            stack.push(i);
        }
        for (int i = 0; i < length; i++) {
            int a = height[i] * (nextSmallerElements[i] - previousSmallerElements[i] - 1);
            area = Math.max(a, area);
        }
        return area;
    }
}
