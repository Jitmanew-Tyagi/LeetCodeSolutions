class Solution {
    public int uniquePaths(int m, int n) {
        // return rec(0, 0, m -  1, n - 1);
        int[][] dp = new int[m][n];
        // return memo(0, 0, m - 1, n - 1, dp);
        return tab(0, 0, m - 1, n - 1, dp);
    }
    
    public int rec(int sr, int sc, int er, int ec) {
        if(sr == er && sc == ec) return 1;
        
        int ans = 0;
        if(sr < er) ans += rec(sr + 1, sc, er, ec);
        if(sc < ec) ans += rec(sr, sc + 1, er, ec);
        
        return ans;
    }
    
    public int memo(int sr, int sc, int er, int ec, int[][] dp) {
        if(sr == er && sc == ec) return dp[sr][sc] = 1;
        if(dp[sr][sc] != 0) return dp[sr][sc];
        int ans = 0;
        if(sr < er) ans += memo(sr + 1, sc, er, ec, dp);
        if(sc < ec) ans += memo(sr, sc + 1, er, ec, dp);
        
        return dp[sr][sc] = ans;
    }
    
    public int tab(int SR, int SC, int ER, int EC, int[][] dp) {
        for(int sr = ER; sr >= SR; sr --) {
            for(int sc = EC; sc >= SC; sc --) {
                if(sr == ER && sc == EC) {
                    dp[sr][sc] = 1;
                    continue;
                }
                int ans = 0;
                if(sr < ER) ans += dp[sr + 1][sc];//memo(sr + 1, sc, er, ec, dp);
                if(sc < EC) ans += dp[sr][sc + 1];//memo(sr, sc + 1, er, ec, dp);
                dp[sr][sc] = ans;
            }
        }       
        return dp[SR][SC];
    }
    
    
}