class Solution {
    public long minIncrementOperations(int[] nums, int k) {
        // long[] dp = new long[nums.length + 1];
        // return tab(nums, 0, k, dp);
        return dpOptimised(nums, k);
    }
    
    public long tab(int[] nums, int I, int k, long[] dp) {
        for(int i = nums.length; i >= I; i --) {
            if(i == nums.length) dp[i] = 0; 
            else {
                long ans = Long.MAX_VALUE;
                long cost = Math.max(0, k - nums[i]);
                for(int j = 1; j <= 3; j ++) {
                    if(i + j <= nums.length) {
                        ans = Math.min(ans, dp[i + j]);
                    }
                }
                dp[i] = ans + cost;
            }
        }
        return Math.min(dp[0], Math.min(dp[1], dp[2]));
    }
    
    public long dpOptimised(int[] nums, int k) {
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