class Solution {
    public int numIdenticalPairs(int[] nums) {
        int[] hm = new int[101];
        for(int ele : nums) hm[ele] ++;
        int ans = 0;
        for(int freq : hm) 
            ans += (freq * (freq - 1)) / 2;
        return ans;
    }
}