class MyHashMap {
    int[] hm;
    public MyHashMap() {
        hm = new int[1_000_001];
        Arrays.fill(hm, -1);
    }
    
    public void put(int key, int value) {
        hm[key] = value;
    }
    
    public int get(int key) {
        return hm[key];
    }
    
    public void remove(int key) {
        hm[key] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */