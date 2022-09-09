class MyStack {
    Queue<Integer> que;
    public MyStack() {
        que = new LinkedList<>();
    }
    
    public void push(int x) { //O(1)
        que.add(x);
    }
    
    public int pop() { //O(n)
        int n = que.size();
        for(int i = 0; i < n - 1; i ++) que.add(que.remove());
        return que.remove();
    }
    
    public int top() { //O(n)
        int n = que.size();
        for(int i = 0; i < n - 1; i ++) que.add(que.remove());
        int val = que.peek();
        que.add(que.remove());
        return val;
    }
    
    public boolean empty() {
        return que.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */