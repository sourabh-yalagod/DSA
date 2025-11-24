package stackAndQueue;

import java.util.Stack;

public class MinStack {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public MinStack() {

    }

    public void push(int val) {
        stack.push(val);
        if(minStack.isEmpty()){
            minStack.push(val);
            return;
        }
        if (val < minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        if (!stack.isEmpty()) {
            int value = stack.pop();
            if (!minStack.isEmpty()) {
                if (value == minStack.peek())
                    minStack.pop();
            }
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
