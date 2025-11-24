package stackAndQueue;

import java.util.Stack;

public class StackAndQueue {
    public static void main(String[] args) {
        String paras = "{{([])}}";
        System.out.println(isValid(paras));
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


}
