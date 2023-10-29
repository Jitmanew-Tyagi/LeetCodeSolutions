class Solution {
    public long minIncrementOperations(int[] nums, int k) {
        long dp, dp1 = 0, dp2 = 0, dp3 = 0; 
        for(int ele : nums) {
            dp = Math.max(0, k - ele) + Math.min(dp1, Math.min(dp2, dp3));
            dp1 = dp2;
            dp2 = dp3;
            dp3 = dp;
        }
        return Math.min(dp1, Math.min(dp2, dp3));
    }
}