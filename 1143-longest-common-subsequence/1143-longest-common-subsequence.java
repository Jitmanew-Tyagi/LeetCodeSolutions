class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for(int[] d : dp) Arrays.fill(d, -1);
        return rec(text1, text2, 0, 0, dp);
    }
    
    public int rec(String a, String b, int i, int j, int[][] dp) {
        if(a.length() == i || b.length() == j) return dp[i][j] = 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(a.charAt(i) == b.charAt(j)) {
            return dp[i][j] = 1 + rec(a, b, i + 1, j + 1, dp);
        } else {
            int a1 = rec(a, b, i + 1, j, dp);
            int a2 = rec(a, b, i, j + 1, dp);
            return dp[i][j] = Math.max(a1, a2);
        }
    }
}