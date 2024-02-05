class Solution {
    public int fib(int n) {
        int[] dp = new int[n + 1];
        return tab(n, dp);
    }
    
    public int memo(int n, int[] dp) {
        if(n <= 1) return dp[n] = n;
        if(dp[n] != 0) return dp[n];
        return dp[n] = memo(n - 1, dp) + memo(n - 2, dp);
    }
    
    public int tab(int N, int[] dp) {
        for(int n = 0; n <= N; n ++) {
            if(n <= 1) {
                dp[n] = n;
                continue;
            }
            dp[n] = dp[n - 1] + dp[n - 2]; //memo(n - 1, dp) + memo(n - 2, dp);
            continue;
        }
        
        return dp[N];
    }
}