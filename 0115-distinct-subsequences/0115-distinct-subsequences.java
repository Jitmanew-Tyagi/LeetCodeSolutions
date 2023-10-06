class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for(int[] d : dp) Arrays.fill(d, -1);
        // return rec(s, t);
        // return memo(s, t, 0, 0, dp);
        return tab(s, t, 0, 0, dp);
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
    
    public int tab(String s, String t, int I, int J, int[][] dp) {
        for(int i = s.length(); i >= I; i --) {
            for(int j = t.length(); j >= J; j --) {
                if(t.length() == j) {
                    dp[i][j] = 1;
                    continue;
                }
                
                if(s.length() == i) {
                    dp[i][j] = 0;
                    continue;
                }
                
                int ans = 0;
                if(s.charAt(i) == t.charAt(j)) {
                    ans += dp[i + 1][j + 1];//memo(s, t, i + 1, j + 1, dp);
                }
                ans += dp[i + 1][j];//memo(s, t, i + 1, j, dp);
                dp[i][j] = ans;
            }
        }
        return dp[I][J];
    }
}