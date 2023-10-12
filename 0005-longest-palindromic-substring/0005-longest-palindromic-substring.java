class Solution {
    public String longestPalindrome(String s) {
        String[][] dp = new String[s.length()][s.length()];
        // return rec(s, 0, s.length() - 1);
        // return memo(s, 0, s.length() - 1, dp);
        return tab(s, 0, s.length() - 1, dp);
    }
    
    public String rec(String str, int s, int e) {
        if(s > e) return "";
        if(s == e) return str.substring(s, e + 1);
        if(str.charAt(s) == str.charAt(e) && rec(str, s + 1, e - 1).length() == (e - s - 1)) 
            return str.charAt(s) + rec(str, s + 1, e - 1) + str.charAt(e);
        String c1 = rec(str, s + 1, e), c2 = rec(str, s, e - 1);
        return c1.length() > c2.length() ? c1 : c2;
    }
    
    public String memo(String str, int s, int e, String[][] dp) {
        if(s > e) return "";
        if(s == e) return dp[s][e] = str.substring(s, e + 1);
        if(dp[s][e] != null) return dp[s][e];
        if(str.charAt(s) == str.charAt(e) && memo(str, s + 1, e - 1, dp).length() == (e - s - 1)) 
            return dp[s][e] = str.charAt(s) + memo(str, s + 1, e - 1, dp) + str.charAt(e);
        String c1 = memo(str, s + 1, e, dp), c2 = memo(str, s, e - 1, dp);
        return dp[s][e] = c1.length() > c2.length() ? c1 : c2;
    }
    
    public String tab(String str, int S, int E, String[][] dp) {
        for(int s = str.length() - 1; s >= 0; s --) {
            for(int e = 0; e <= E; e ++) {
                if(s > e) dp[s][e] = "";
                else if(s == e) dp[s][e] = str.substring(s, e + 1);
                else if(str.charAt(s) == str.charAt(e) && dp[s + 1][e - 1].length() == (e - s - 1)) {
                    dp[s][e] = str.charAt(s) + dp[s + 1][e - 1] + str.charAt(e);
                } else  {
                    String c1 = dp[s + 1][e], c2 = dp[s][e - 1];
                    dp[s][e] = c1.length() > c2.length() ? c1 : c2;
                }
            }
        }
        return dp[S][E];
    }
}