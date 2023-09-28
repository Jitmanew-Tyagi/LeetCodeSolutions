class Solution {
    public int minCostClimbingStairs(int[] cost) {
        return Math.min(rec(cost, cost.length - 1, new int[cost.length]), rec(cost, cost.length - 2, new int[cost.length]));
    }
    
    public int rec(int[] arr, int n, int[]dp) {
        if(n < 0) return 0;
        if(dp[n] != 0) return dp[n];
        if(n <= 1) return dp[n] = arr[n];
        return dp[n] = Math.min(rec(arr, n - 1, dp), rec(arr, n - 2, dp)) + arr[n];
    }
}