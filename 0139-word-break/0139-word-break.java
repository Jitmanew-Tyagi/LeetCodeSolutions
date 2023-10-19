class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> hs = new HashSet<>();
        for(String str : wordDict) hs.add(str);
        // return rec(s, 0, 0, hs);
        int[][] dp = new int[s.length() + 1][s.length() + 1];
        for(int[] d : dp) Arrays.fill(d, -1);
        return memo(s, 0, 0, hs, dp);
    }
    
    public boolean rec(String s, int si, int ei, HashSet<String> hs) {
        if(ei == s.length()) return si == s.length();
        boolean ans = false;
        if(hs.contains(s.substring(si, ei + 1))) ans = ans || rec(s, ei + 1, ei + 1, hs);
        ans = ans || rec(s, si, ei + 1, hs);
        return ans;
    }
    
    public boolean memo(String s, int si, int ei, HashSet<String> hs, int[][] dp) {
        if(ei == s.length()) {
            dp[si][ei] = si == s.length() ? 1 : 0;
            return dp[si][ei] == 1;
        }
        if(dp[si][ei] != -1) return dp[si][ei] == 1;
        boolean ans = false;
        if(hs.contains(s.substring(si, ei + 1))) ans = ans || memo(s, ei + 1, ei + 1, hs, dp);
        ans = ans || memo(s, si, ei + 1, hs, dp);
        dp[si][ei] = ans ? 1 : 0;
        return ans;
    }
}