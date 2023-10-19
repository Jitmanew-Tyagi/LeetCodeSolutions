class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> hs = new HashSet<>();
        for(String str : wordDict) hs.add(str);
        // return rec(s, 0, 0, hs);
        // int[] dp = new int[s.length() + 1];
        // Arrays.fill(dp, -1);
        // return memo(s, 0, 0, hs, dp);
        return tab(s, 0, 0, hs, new boolean[s.length() + 1]);
    }
    
    public boolean rec(String s, int si, int ei, HashSet<String> hs) {
        if(ei == s.length()) return si == s.length();
        boolean ans = false;
        if(hs.contains(s.substring(si, ei + 1))) ans = ans || rec(s, ei + 1, ei + 1, hs);
        ans = ans || rec(s, si, ei + 1, hs);
        return ans;
    }
    
    public boolean memo(String s, int si, int ei, HashSet<String> hs, int[] dp) {
        if(ei == s.length()) {
            dp[si] = si == s.length() ? 1 : 0;
            return dp[si] == 1;
        }
        if(dp[si] != -1) return dp[si] == 1;
        boolean ans = false;
        if(hs.contains(s.substring(si, ei + 1))) ans = ans || memo(s, ei + 1, ei + 1, hs, dp);
        ans = ans || memo(s, si, ei + 1, hs, dp);
        dp[si] = ans ? 1 : 0;
        return ans;
    }
    
    public boolean tab(String s, int SI, int EI, HashSet<String> hs, boolean[] dp) {
        for(int si = s.length(); si >= SI; si --) {
            for(int ei = s.length(); ei >= EI; ei --) {
                boolean ans = false;
                if(ei == s.length()) {
                    dp[si] = si == s.length();
                    continue;
                }
                if(ei < si) {
                    // dp[si] = true;
                    continue;
                }
                if(hs.contains(s.substring(si, ei + 1))) ans = ans || dp[ei + 1];
                ans = ans || dp[si];
                dp[si] = ans;
            }
        }
        return dp[SI];
    }
}