package stack;

import java.util.Objects;
import java.util.Stack;

public class Solutions {
    public static void main(String[] args) {
        int[] array = {30, 38, 30, 36, 35, 40, 28};
        for (int ele : dailyTemperatures(array)) {
            System.out.print(" " + ele);
        }
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
}
