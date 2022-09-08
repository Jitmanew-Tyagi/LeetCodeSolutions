class Solution {
    public int[][] kClosest(int[][] p, int k) {
        int ans[][] = new int[k][2], idx = 0, n = p.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            int d1 = (p[a][0] * p[a][0]) + (p[a][1] * p[a][1]);
            int d2 = (p[b][0] * p[b][0]) + (p[b][1] * p[b][1]);
            return d2 - d1;
        });
        for(int i = 0; i < n; i ++) {
            pq.add(i);
            if(pq.size() > k) pq.remove();
        }
        
        while(!pq.isEmpty()) ans[idx ++] = p[pq.remove()];
        return ans;
    }
}