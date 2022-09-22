class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> hm = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()) hm.put(c, hm.getOrDefault(c, 0) + 1);
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(char c : hm.keySet()) pq.add(new Pair(c, hm.get(c)));
        while(!pq.isEmpty()) {
            Pair rv = pq.remove();
            for(int i = 0; i < rv.f; i ++) sb.append(rv.c);
        }
        return sb.toString();
    }
    
    class Pair implements Comparable<Pair>{
        char c;
        int f;
        Pair(char c, int f) {
            this.c = c; 
            this.f = f;
        }
        
        public int compareTo(Pair other) {
            return other.f - this.f;
        }
    }
} 