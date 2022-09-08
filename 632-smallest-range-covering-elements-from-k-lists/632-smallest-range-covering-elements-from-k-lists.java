class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return nums.get(a[0]).get(a[1]) - nums.get(b[0]).get(b[1]);
        });
        int maxValue = -(int)1e9, sp = -1, ep = -1, range = Integer.MAX_VALUE;
        for(int i = 0; i < nums.size(); i ++){
            pq.add(new int[] {i, 0});
            maxValue = Math.max(maxValue, nums.get(i).get(0));
        }
        while(pq.size() == nums.size()) {
            int rem[] = pq.remove(), val = nums.get(rem[0]).get(rem[1]);
            if(maxValue - val < range) {
                range = maxValue - val;
                sp = val;
                ep = maxValue;
            }
            if(rem[1] + 1 < nums.get(rem[0]).size()) {
                pq.add(new int[] {rem[0], rem[1] + 1});
                maxValue = Math.max(maxValue, nums.get(rem[0]).get(rem[1] + 1));
            }
        }
        return new int[] {sp, ep};
    }
}