class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int[][] dp = new int[21][2001];
        for(int[] d : dp) Arrays.fill(d, -1001);
        return rec(nums.length, nums, 0, target, 0, dp);
    }
    
    public int rec(int n, int[] nums, int i, int target, int sum, int[][] dp) {
        if(i == n) 
            return dp[i][sum + 1000] = sum == target ? 1 : 0;
        if(dp[i][sum + 1000] != -1001) return dp[i][sum + 1000];
        int ans = 0;
        ans += rec(n, nums, i + 1, target, sum - nums[i], dp);
        ans += rec(n, nums, i + 1, target, sum + nums[i], dp);
        return dp[i][sum + 1000] = ans;
    }
}