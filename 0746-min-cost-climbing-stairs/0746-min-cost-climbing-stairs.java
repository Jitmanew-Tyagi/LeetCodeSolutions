class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length, dp[] = new int[n + 2];
        // return Math.min(rec(0, n, cost), rec(1, n, cost));
        // return Math.min(memo(0, n, cost, dp), memo(1, n, cost, dp));
        return Math.min(tab(0, n, cost, dp), tab(1, n, cost, dp));
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
    
    public int tab(int I, int n, int[] cost, int[] dp) {
        for(int i = n; i >= I; i --) {
            if(i >= n) {
                dp[i] = 0;
                continue;
            }
            int oneStepCost = dp[i + 1];//memo(i + 1, n, cost, dp);
            int twoStepCost = dp[i + 2];//memo(i + 2, n, cost, dp);
            dp[i] = Math.min(oneStepCost, twoStepCost) + cost[i];
        }
        return dp[I];
    }
}