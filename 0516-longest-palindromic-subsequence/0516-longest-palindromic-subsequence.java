class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length(), dp[][] = new int[n][n];
        for(int[] d : dp) Arrays.fill(d, -1);
        return helper(s, 0, n - 1, dp);
    }
    
    public int helper(String str, int s, int e, int[][] dp) {
        if(e < s) return 0;
        if(s == e) return dp[s][e] = 1;
        if(dp[s][e] != -1) return dp[s][e];
        return dp[s][e] = str.charAt(s) == str.charAt(e) ? helper(str, s + 1, e - 1, dp) + 2 :
        Math.max(helper(str, s + 1, e, dp), helper(str, s, e - 1, dp));
    }
}