class MyQueue {
    Stack<Integer> stack;
    Stack<Integer> queueStack;
    public MyQueue() {
        this.stack = new Stack<>();
        this.queueStack = new Stack<>();
    }
    
    public void push(int x) {
        while(!stack.isEmpty()){
            queueStack.push(stack.pop());
        }
        queueStack.push(x);
        while(!queueStack.isEmpty()){
            stack.push(queueStack.pop());
        }
    }
    
    public int pop() {
        return stack.pop();
    }
    
    public int peek() {
        return stack.peek();
    }
    
    public boolean empty() {
        return stack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */