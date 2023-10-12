class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for(int[] d : dp) Arrays.fill(d, -1);
        // return rec(word1, word2, 0, 0);
        return memo(word1, word2, 0, 0, dp);
    }
    
    public int rec(String a, String b, int i, int j) {
        if(i == a.length() || j == b.length()) 
            return Math.max(a.length() - i, b.length() - j);
        if(a.charAt(i) == b.charAt(j)) return rec(a, b, i + 1, j + 1);
        int x = rec(a, b, i + 1, j), y = rec(a, b, i, j + 1);
        return Math.min(x, y) + 1;
    }
    
    public int memo(String a, String b, int i, int j, int[][] dp) {
        if(i == a.length() || j == b.length()) 
            return dp[i][j] = Math.max(a.length() - i, b.length() - j);
        if(dp[i][j] != -1) return dp[i][j];
        if(a.charAt(i) == b.charAt(j)) return dp[i][j] = memo(a, b, i + 1, j + 1, dp);
        int x = memo(a, b, i + 1, j, dp), y = memo(a, b, i, j + 1, dp);
        return dp[i][j] = Math.min(x, y) + 1;
    }
}