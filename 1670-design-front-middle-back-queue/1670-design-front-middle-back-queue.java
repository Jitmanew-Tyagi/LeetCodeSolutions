class FrontMiddleBackQueue {
    List<Integer> que;
    public FrontMiddleBackQueue() {
        que = new ArrayList<>();
    }
    
    public void pushFront(int val) {
        que.add(0, val);
    }
    
    public void pushMiddle(int val) {
        que.add(que.size() / 2, val);
    }
    
    public void pushBack(int val) {
        que.add(val);
    }
    
    public int popFront() {
        return que.isEmpty() ? -1 : que.remove(0);
    }
    
    public int popMiddle() {
        return que.isEmpty() ? -1 : que.remove((que.size() - 1) / 2) ;
    }
    
    public int popBack() {
        return que.isEmpty() ? -1 : que.remove(que.size() - 1) ;
    }
}

/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
 * obj.pushFront(val);
 * obj.pushMiddle(val);
 * obj.pushBack(val);
 * int param_4 = obj.popFront();
 * int param_5 = obj.popMiddle();
 * int param_6 = obj.popBack();
 */