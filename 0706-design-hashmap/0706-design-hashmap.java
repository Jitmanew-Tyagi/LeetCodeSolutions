class MyHashMap {
    ListNode[] hm;
    public MyHashMap() {
        hm = new ListNode[100_001];
    }
    
    public void put(int key, int value) {
        int idx = idx(key);
        if(hm[idx] == null) hm[idx] = new ListNode(-1, -1);
        ListNode prev = find(hm[idx], key);
        if(prev.next == null) prev.next = new ListNode(key, value);
        else prev.next.val = value;
    }
    
    public int get(int key) {
        int idx = idx(key);
        if(hm[idx] == null) return -1;
        ListNode prev = find(hm[idx], key);
        return prev.next == null ? -1 : prev.next.val;
    }
    
    public void remove(int key) {
        int idx = idx(key);
        if(hm[idx] == null) return;
        ListNode prev = find(hm[idx], key);
        if(prev.next != null) prev.next = prev.next.next;
    }
    
    private int idx(int key) {
        return Integer.hashCode(key) % hm.length;
    }
    
    private ListNode find(ListNode bucket, int key) {
        ListNode node = bucket, prev = null;
        while(node != null && node.key != key) {
            prev = node;
            node = node.next;
        }
        return prev;
    }
    
    class ListNode {
        int key;
        int val;
        ListNode next;
        
        ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */