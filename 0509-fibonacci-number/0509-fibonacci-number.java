class Solution {
    public int fib(int n) {
        int[] dp = new int[n + 1];
        // return rec(n);
        return memo(n, dp);
    }
    
    public int rec(int n) {
        if(n <= 1) return n;
        return rec(n - 1) + rec(n - 2);
    }
    
    public int memo(int n, int[] dp) {
        if(n <= 1) return dp[n] = n;
        if(dp[n] != 0) return dp[n];
        return dp[n] = memo(n - 1, dp) + memo(n - 2, dp);
    }
}