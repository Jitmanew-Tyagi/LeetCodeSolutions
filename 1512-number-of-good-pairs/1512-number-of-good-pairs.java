class Solution {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> hm = new HashMap<>();
        for(int ele : nums) hm.put(ele, hm.getOrDefault(ele, 0) + 1);
        int ans = 0;
        for(int key : hm.keySet()) {
            int freq = hm.get(key);
            ans += (freq * (freq - 1)) / 2;
        }
        return ans;
    }
}