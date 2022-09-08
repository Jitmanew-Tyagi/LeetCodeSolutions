class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int stone : stones) pq.add(stone);
        while(pq.size() >= 2) {
            int s1 = pq.remove(), s2 = pq.remove();
            int out = Math.abs(s1 - s2);
            if(out > 0) pq.add(out);
        }
        return pq.size() > 0 ? pq.remove() : 0;
    }
}