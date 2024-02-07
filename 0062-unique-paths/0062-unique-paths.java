class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        return memo(0, 0, m - 1, n - 1, dp);
    }
    
    public int memo(int sr, int sc, int er, int ec, int[][] dp) {
        if(sr == er && sc == ec) return dp[sr][sc] = 1;
        if(dp[sr][sc] != 0) return dp[sr][sc];
        int ans = 0;
        if(sr < er) ans += memo(sr + 1, sc, er, ec, dp);
        if(sc < ec) ans += memo(sr, sc + 1, er, ec, dp);
        return dp[sr][sc] = ans;
    }
}