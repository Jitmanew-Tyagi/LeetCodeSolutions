class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> hm = new HashMap<>();
        List<String> ans = new LinkedList<>();
        for(String s : words) hm.put(s, hm.getOrDefault(s, 0) + 1);
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(String s : hm.keySet()) {
            pq.add(new Pair(s, hm.get(s)));
            if(pq.size() > k) pq.remove();
        }
        while(!pq.isEmpty()) {
            ans.add(0, pq.remove().str);
        }
        return ans;
    }
    
    class Pair implements Comparable<Pair> {
        String str;
        int count;
        Pair(String str, int count) {
            this.str = str;
            this.count = count;
        }
        
        @Override
        public int compareTo(Pair other) {
            if(this.count == other.count) return other.str.compareTo(this.str);
            return this.count - other.count;
        }
    }
}