class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length, dp[] = new int[n + 2];
        // return Math.min(rec(0, n, cost), rec(1, n, cost));
        return Math.min(memo(0, n, cost, dp), memo(1, n, cost, dp));
    }
    
    public int rec(int i, int n, int[] cost) {
        if(i >= n) return 0;
        int oneStepCost = rec(i + 1, n, cost);
        int twoStepCost = rec(i + 2, n, cost);
        return Math.min(oneStepCost, twoStepCost) + cost[i];
    }  
    
    public int memo(int i, int n, int[] cost, int[] dp) {
        if(i >= n) return dp[i] = 0;
        if(dp[i] != 0) return dp[i];
        int oneStepCost = memo(i + 1, n, cost, dp);
        int twoStepCost = memo(i + 2, n, cost, dp);
        return dp[i] = Math.min(oneStepCost, twoStepCost) + cost[i];
    }  
}