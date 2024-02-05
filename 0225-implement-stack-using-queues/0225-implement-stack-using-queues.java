class MyStack {
    Queue<Integer> que;
    public MyStack() {
        que = new LinkedList<>();
    }
    
    public void push(int x) { //O(n)
        que.add(x);
    }
    
    public int pop() {
        int size = que.size();
        while(size --> 1) que.add(que.remove());
        return que.remove();
    }
    
    public int top() {
        int size = que.size();
        while(size --> 1) que.add(que.remove());
        int ele = que.remove();
        que.add(ele);
        return ele;
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