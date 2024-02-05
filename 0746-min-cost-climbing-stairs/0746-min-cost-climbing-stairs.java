class Solution {
    public int minCostClimbingStairs(int[] cost) {
        // return Math.min(rec(0, cost.length, cost), rec(1, cost.length, cost));
        int n = cost.length;
        int[] dp = new int[n + 2];
        return Math.min(memo(0, n, cost, dp), memo(1, n, cost, dp));
    }
    
    public int rec(int i, int n, int[] cost) {
        if(i >= n) return 0;
        int pay = cost[i];
        int oneStep = rec(i + 1, n, cost);
        int twoStep = rec(i + 2, n, cost);
        return pay + Math.min(oneStep, twoStep);
    }
    
    public int memo(int i, int n, int[] cost, int[] dp) {
        if(i >= n) return dp[i] = 0;
        if(dp[i] != 0) return dp[i];
        int pay = cost[i];
        int oneStep = memo(i + 1, n, cost, dp);
        int twoStep = memo(i + 2, n, cost, dp);
        return dp[i] = pay + Math.min(oneStep, twoStep);
    }
}