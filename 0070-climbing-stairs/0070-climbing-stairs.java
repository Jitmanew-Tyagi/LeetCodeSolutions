class Solution {
    public int climbStairs(int n) {
        // return rec(n);
        int[] dp = new int[n + 1];
        return memo(n, dp);
    }
    
    public int rec(int n) {
        if(n == 0) return 1;
        int ans = 0;
        if(n - 1 >= 0) ans += rec(n - 1);
        if(n - 2 >= 0) ans += rec(n - 2);
        return ans;
    }
    
    public int memo(int n, int[] dp) {
        if(n == 0) return dp[n] = 1;
        if(dp[n] != 0) return dp[n];
        int ans = 0;
        if(n - 1 >= 0) ans += memo(n - 1, dp);
        if(n - 2 >= 0) ans += memo(n - 2, dp);
        return dp[n] = ans;
    }
}