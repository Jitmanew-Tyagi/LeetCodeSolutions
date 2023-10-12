class Solution {
    public String longestPalindrome(String s) {
        String[][] dp = new String[s.length()][s.length()];
        // return rec(s, 0, s.length() - 1);
        return memo(s, 0, s.length() - 1, dp);
    }
    
    public String rec(String str, int s, int e) {
        if(s > e) return "";
        if(s == e) return str.substring(s, e + 1);
        if(str.charAt(s) == str.charAt(e)) return str.charAt(s) + rec(str, s + 1, e - 1) + str.charAt(e);
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
}