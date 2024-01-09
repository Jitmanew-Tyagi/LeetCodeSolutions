class Solution {
    public int minOperations(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int ele : nums) hm.put(ele, hm.getOrDefault(ele, 0) + 1);
        int ans = 0; 
        for(int key : hm.keySet()) {
            int freq = hm.get(key);
            if(freq == 1) return -1;
            int rem = freq % 3;
            if(rem == 0) ans += (freq / 3);
            else ans += (freq / 3) + 1;
        }
        return ans;
    }
}