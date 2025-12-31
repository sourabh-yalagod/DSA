package stack;

import java.util.Objects;
import java.util.Stack;

public class Solutions {
    public static void main(String[] args) {
        String[] strings = {"1","2","+","3","*","4","-"};
        System.out.println(polishFlagCompute(strings));
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
}
