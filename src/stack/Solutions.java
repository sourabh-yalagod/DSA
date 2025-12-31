package stack;

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
}
