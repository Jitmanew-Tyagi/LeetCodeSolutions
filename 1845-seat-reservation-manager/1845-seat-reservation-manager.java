class SeatManager {
    
    boolean[] arr;
    Queue<Integer> pq = new PriorityQueue<>();
    
    public SeatManager(int n) {
        arr = new boolean[n + 1];
        for(int i = 1; i <= n; i ++) pq.add(i);
    }
    
    public int reserve() {
        int idx = pq.remove();
        while(arr[idx]) idx = pq.remove();
        arr[idx] = true;
        return idx;
    }
    
    public void unreserve(int seatNumber) {
        arr[seatNumber] = false;
        pq.add(seatNumber);
        
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */