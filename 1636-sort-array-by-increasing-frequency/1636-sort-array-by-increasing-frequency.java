class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> hm = new HashMap<>();
        for(int i : nums) hm.put(i, hm.getOrDefault(i, 0) + 1);
        Pair[] p = new Pair[hm.size()];
        int idx = 0;
        for(int i : hm.keySet()) p[idx ++] = new Pair(i, hm.get(i));
        Arrays.sort(p);
        int ans[] = new int[nums.length];
        idx = 0;
        for(Pair ele : p)  {
            int e = ele.ele, f = ele.freq;
            while(f --> 0)
                ans[idx ++] = e;
        }
        return ans;
    }
    
    class Pair implements Comparable<Pair> {
        int ele;
        int freq;
        
        Pair(int ele, int freq) {
            this.ele = ele;
            this.freq = freq;
        }
        
        public int compareTo(Pair other) {
            if(other.freq == this.freq) return other.ele - this.ele; 
            return this.freq - other.freq;
        }
    }
}