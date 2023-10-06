class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        // return memo(word1, word2, 0, 0, dp);
        return tab(word1, word2, 0, 0, dp);
    }
    
    public int memo(String a, String b, int i, int j, int[][] dp) {
        if(b.length() == j) return a.length() - i;
        if(a.length() == i) return b.length() - j;
        if(dp[i][j] != 0) return dp[i][j];
        if(a.charAt(i) == b.charAt(j)) 
            return dp[i][j] = memo(a, b, i + 1, j + 1, dp);
        int insert = memo(a, b, i, j + 1, dp);
        int delete = memo(a, b, i + 1, j, dp);
        int replace = memo(a, b, i + 1, j + 1, dp);
        return dp[i][j] = Math.min(insert, Math.min(delete, replace)) + 1;
    }
    
    public int tab(String a, String b, int I, int J, int[][] dp) {
        for(int i = a.length(); i >= I; i --) {
            for(int j = b.length(); j >= J; j --) {
                if(b.length() == j)  {
                    dp[i][j] = a.length() - i;
                    continue;
                }
                if(a.length() == i)  {
                    dp[i][j] = b.length() - j;
                    continue;
                }
                if(a.charAt(i) == b.charAt(j)){ 
                    dp[i][j] = dp[i + 1][j + 1];//memo(a, b, i + 1, j + 1, dp);
                    continue;
                }
                int insert = dp[i][j + 1];//memo(a, b, i, j + 1, dp);
                int delete = dp[i + 1][j];//memo(a, b, i + 1, j, dp);
                int replace = dp[i + 1][j + 1];//memo(a, b, i + 1, j + 1, dp);
                dp[i][j] = Math.min(insert, Math.min(delete, replace)) + 1;
            }
        }
        return dp[I][J];
    }
}