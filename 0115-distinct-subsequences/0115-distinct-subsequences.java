class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for(int[] d : dp) Arrays.fill(d, -1);
        // return rec(s, t);
        return memo(s, t, 0, 0, dp);
    }
    
    public int rec(String s, String t) {
        if(t.length() == 0) return 1;
        if(s.length() == 0) return 0;
        int ans = 0;
        if(s.charAt(0) == t.charAt(0)) {
            ans += rec(s.substring(1), t.substring(1));
        }
        ans += rec(s.substring(1), t);
        return ans;
    }
    
    public int memo(String s, String t, int i, int j, int[][] dp) {
        if(t.length() == j) return dp[i][j] = 1;
        if(s.length() == i) return dp[i][j] = 0;
        if(dp[i][j] != -1) return dp[i][j];
        int ans = 0;
        if(s.charAt(i) == t.charAt(j)) {
            ans += memo(s, t, i + 1, j + 1, dp);
        }
        ans += memo(s, t, i + 1, j, dp);
        return dp[i][j] = ans;
    }
}