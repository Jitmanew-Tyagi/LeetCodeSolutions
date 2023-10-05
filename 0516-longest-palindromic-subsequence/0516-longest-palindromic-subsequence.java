class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length(), dp[][] = new int[n][n];
        for(int[] d : dp) Arrays.fill(d, -1);
        // return memo(s, 0, n - 1, dp);  
        return tab(s, 0, n - 1, dp);
    }
    
    public int memo(String str, int s, int e, int[][] dp) {
        if(e < s) return 0;
        if(s == e) return dp[s][e] = 1;
        if(dp[s][e] != -1) return dp[s][e];
        return dp[s][e] = str.charAt(s) == str.charAt(e) ? memo(str, s + 1, e - 1, dp) + 2 :
        Math.max(memo(str, s + 1, e, dp), memo(str, s, e - 1, dp));
    }
    
    public int tab(String str, int S, int E, int[][] dp) {
        for(int s = str.length() - 1; s >= S; s --) {
            for(int e = 0; e <= E; e ++) {
                if(e < s) {
                    dp[s][e] = 0;
                    continue;
                }
                if(s == e) {
                    dp[s][e] = 1;
                    continue;
                }
                dp[s][e] = str.charAt(s) == str.charAt(e) ? dp[s + 1][e - 1] + 2 : Math.max(dp[s + 1][e], dp[s][e - 1]);
            }
        }
        return dp[S][E];
    }
}