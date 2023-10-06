class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        return rec(word1, word2, 0, 0, dp);
    }
    
    public int rec(String a, String b, int i, int j, int[][] dp) {
        if(b.length() == j) return a.length() - i;
        if(a.length() == i) return b.length() - j;
        if(dp[i][j] != 0) return dp[i][j];
        if(a.charAt(i) == b.charAt(j)) 
            return dp[i][j] = rec(a, b, i + 1, j + 1, dp);
        int insert = rec(a, b, i, j + 1, dp);
        int delete = rec(a, b, i + 1, j, dp);
        int replace = rec(a, b, i + 1, j + 1, dp);
        return dp[i][j] = Math.min(insert, Math.min(delete, replace)) + 1;
    }
}