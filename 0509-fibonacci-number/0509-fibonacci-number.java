class Solution {
    public int fib(int n) {
        // return rec(n);
        int[] dp = new int[n + 1];
        return tab(n, dp);
    }
    
    public int rec(int n) {
        if(n <= 1) return n;
        int f1 = rec(n - 1);
        int f2 = rec(n - 2);
        return f1 + f2;
    }
    
    public int memo(int n, int[] dp) {
        if(n <= 1) return dp[n] = n;
        if(dp[n] != 0) return dp[n];
        int f1 = memo(n - 1, dp);
        int f2 = memo(n - 2, dp);
        return dp[n] = f1 + f2;
    }
    
    public int tab(int N, int[] dp) {
        for(int n = 0; n <= N; n ++) {
            if(n <= 1){
               dp[n] = n;
                continue;
            }
            int f1 = dp[n - 1];//memo(n - 1, dp);
            int f2 = dp[n - 2];//memo(n - 2, dp);
            dp[n] = f1 + f2;
        }
        
        return dp[N];
    }
    
    // public int tab(int n, int[] dp) {
    //     for(int i = 0; i <= n; i ++) {
    //         if(i <= 1) dp[i] = i;
    //         else {
    //             dp[i] = dp[i - 1] + dp[i - 2];
    //         }
    //     }
    //     return dp[n];
    // }
}