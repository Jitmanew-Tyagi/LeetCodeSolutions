class Solution {
    public int integerBreak(int n) {
        if(n == 2) return 1;
        if(n == 3) return 2;
        int[] dp = new int[n + 1];
        return rec(n, dp);
    }
    
    public int rec(int n, int[] dp){
        if(n <= 1) return dp[n] = 1;
        if(dp[n] != 0) return dp[n];
        int ans = 1;
        for(int i = 1; i <= n; i ++) {
            ans = Math.max(ans, rec(n - i, dp) * i);
        }
        return dp[n] = ans;
    }
}