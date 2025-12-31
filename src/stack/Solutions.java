package stack;

import java.util.Objects;
import java.util.Stack;

public class Solutions {
    public static void main(String[] args) {
        System.out.println(validParentheses("((]))"));
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


}
