class Solution {
    public int integerBreak(int n) {
        if(n == 2) return 1;
        if(n == 3) return 2;
        int[] dp = new int[n + 1];
        return tab(n, dp);
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
    
    public int tab(int N, int[] dp) {
        for(int n = 0; n <= N; n ++) {
            if(n <= 1) {
                dp[n] = 1;
                continue;
            } 
            int ans = 1;
            for(int i = 1; i <= n; i ++) 
                ans = Math.max(ans, dp[n - i] * i);
            dp[n] = ans;
        }
        return dp[N];
    }
}