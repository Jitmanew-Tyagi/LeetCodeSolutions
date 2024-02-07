class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        return tab(0, 0, m - 1, n - 1, dp);
    }
    
    public int memo(int sr, int sc, int er, int ec, int[][] dp) {
        if(sr == er && sc == ec) return dp[sr][sc] = 1;
        if(dp[sr][sc] != 0) return dp[sr][sc];
        int ans = 0;
        if(sr < er) ans += memo(sr + 1, sc, er, ec, dp);
        if(sc < ec) ans += memo(sr, sc + 1, er, ec, dp);
        return dp[sr][sc] = ans;
    }
    
    //in which direction should I run the loop such that thee dependencies are always reolved first?
    public int tab(int SR, int SC, int ER, int EC, int[][] dp) {
        for(int sr = ER; sr >= SR; sr --) {
            for(int sc = EC; sc >= SC; sc --) {
                if(sr == ER && sc == EC) {
                    dp[sr][sc] = 1;
                    continue;
                }
                int ans = 0;
                if(sr < ER) ans += dp[sr + 1][sc]; //memo(sr + 1, sc, er, ec, dp);
                if(sc < EC) ans += dp[sr][sc + 1]; //memo(sr, sc + 1, er, ec, dp);
                dp[sr][sc] = ans;
            }
        }     
        return dp[SR][SC];
    }
    
}