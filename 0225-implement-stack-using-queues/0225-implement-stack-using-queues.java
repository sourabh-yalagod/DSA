class MyStack {
    Queue<Integer> read;
    Queue<Integer> temp;
    public MyStack() {
        this.read  = new LinkedList<>();
        this.temp  = new LinkedList<>();
    }
    
    public void push(int x) {
        while(!read.isEmpty()){
            temp.add(read.poll());
        }
        read.add(x);
        while(!temp.isEmpty()){
            read.add(temp.poll());
        }
    }
    
    public int pop() {
        return read.poll();
    }
    
    public int top() {
        return read.peek();
    }
    
    public boolean empty() {
        return read.isEmpty();
    }
}


// 2 1
// temp 
// 

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */