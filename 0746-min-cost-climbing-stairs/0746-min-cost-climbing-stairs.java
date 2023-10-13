class Solution {
    public int minCostClimbingStairs(int[] cost) {
        // return Math.min(rec(cost, cost.length - 1, new int[cost.length]), rec(cost, cost.length - 2, new int[cost.length]));
        return Math.min(tab(cost, cost.length - 1, new int[cost.length]), tab(cost, cost.length - 2, new int[cost.length]));
    
    }
    
    public int rec(int[] arr, int n, int[]dp) {
        if(n < 0) return 0;
        if(dp[n] != 0) return dp[n];
        if(n <= 1) return dp[n] = arr[n];
        return dp[n] = Math.min(rec(arr, n - 1, dp), rec(arr, n - 2, dp)) + arr[n];
    }
    
    public int tab(int[] arr, int N, int[] dp) {
        for(int n = 0; n <= N; n ++) {
            if(n <= 1) dp[n] = arr[n];
            else {
                dp[n] = Math.min(dp[n - 1], n - 2 >= 0 ? dp[n - 2] : Integer.MAX_VALUE) + arr[n];
            }
        }
        return dp[N];
    }
}