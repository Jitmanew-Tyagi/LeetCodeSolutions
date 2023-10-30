class Solution {
    public int[] sortByBits(int[] arr) {
        int ans[] = new int[arr.length], idx = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int x : arr) pq.add(new Pair(x, nob(x)));
        while(idx < arr.length) ans[idx ++] = pq.remove().x;
        return ans;
    }
    
    public int nob(int a) {
        int count = 0;
        for(int i = 0; i < 32; i ++) 
            count += ((a & (1 << i)) > 0) ? 1 : 0;
        return count;
    }
    
    public class Pair implements Comparable<Pair>{
        int x;
        int nob;
        
        Pair(int x, int nob) {
            this.x = x;
            this.nob = nob;
        }
        
        @Override
        public int compareTo(Pair other) {
            if(this.nob == other.nob) return this.x - other.x;
            return this.nob - other.nob;
        }
    }
}