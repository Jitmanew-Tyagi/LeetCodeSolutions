class Solution {
    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i : nums) hm.put(i, hm.getOrDefault(i, 0) + 1);
        
        int ans = 0;
        for(int i : hm.keySet()) {
            if(hm.containsKey(i + 1)) {
                int lohs = hm.get(i) + hm.get(i + 1);
                ans = Math.max(ans, lohs);
            }
        }
        return ans;
    }
}