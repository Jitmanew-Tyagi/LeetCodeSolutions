class Solution {
    public int lengthOfLIS(int[] nums) {
        // return rec(nums, 0, -1, 0);
        int ans = 0, n = nums.length, dp[] = new int[n];
        for(int i = 0; i < n; i ++) ans = Math.max(ans, memo(nums, i, dp));
        return ans;
    }
    
    // Recursion on the way up
    public int rec(int[] nums, int i, int last, int len) {
        if(i == nums.length) return len;
        int ans = 0;
        if(i == 0 || nums[i] > last) ans = rec(nums, i + 1, nums[i], len + 1);
        ans = Math.max(ans, rec(nums, i + 1, last, len));
        return ans;
    }
    
    // Recursion on the way down
    public int rec(int[] nums, int ei) {
        int ans = 1;
        for(int i = ei; i >= 0; i --) {
            if(nums[i] < nums[ei]) ans = Math.max(ans, rec(nums, i) + 1);
        }
        return ans;
    }
    
    // Memoization
    public int memo(int[] nums, int ei, int[] dp) {
        if(dp[ei] != 0) return dp[ei];
        int ans = 1;
        for(int i = ei; i >= 0; i --) {
            if(nums[i] < nums[ei]) ans = Math.max(ans, memo(nums, i, dp) + 1);
        }
        return dp[ei] = ans;
    }
}