class MyHashMap {
    Node[] hm;
    public MyHashMap() {
        hm = new Node[100000];
    }
    
    public void put(int key, int value) {
        int idx = idx(key);
        if(hm[idx] == null) hm[idx] = new Node(-1, -1);
        Node prev = find(hm[idx], key);
        if(prev.next == null) prev.next = new Node(key, value);
        else prev.next.val = value;
    }
    
    public int get(int key) {
        int idx = idx(key);
        if(hm[idx] == null) return -1;
        Node prev = find(hm[idx], key);
        return prev.next == null ? -1 : prev.next.val;
    }
    
    public void remove(int key) {
        int idx = idx(key);
        if(hm[idx] == null) return;
        Node prev = find(hm[idx], key);
        if(prev.next != null) prev.next = prev.next.next;
    }
    
    private Node find(Node bucket, int key) {
        Node node = bucket, prev = null;
        while(node != null && node.key != key) {
            prev = node;
            node = node.next;
        }
        return prev;
    }
    
    public int idx(int key) {
        return Integer.hashCode(key) % hm.length;
    }
    
    class Node {
        int key;
        int val;
        Node next;
        
        Node(int key, int val) {
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