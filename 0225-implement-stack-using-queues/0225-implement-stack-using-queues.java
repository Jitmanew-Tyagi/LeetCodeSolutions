class MyStack {
    Queue<Integer> main;
    public MyStack() {
        main = new LinkedList<>();
    }
    
    public void push(int x) { // O(1)
        main.add(x);
    }
    
    public int pop() { //O(n)
        int size = main.size();
        while(size --> 1) main.add(main.remove());
        return main.remove();                      
    }
    
    public int top() { // O(n)
        int size = main.size();
        while(size --> 1) main.add(main.remove());
        
        int lastEle = main.peek();
        main.add(main.remove());
        return lastEle;
    }
    
    public boolean empty() {
        return main.isEmpty();
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