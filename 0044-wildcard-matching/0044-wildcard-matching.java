class Solution {
    public boolean isMatch(String s, String p) {
        int[][] dp = new int[s.length() + 1][p.length() + 1];
        for(int[] d : dp) Arrays.fill(d, -1);
        // return rec(s, p);
        boolean ans = memo(s, p, 0, 0, dp);
        // for(int[] d : dp) {
        //     for(int ele : d) System.out.print(ele + " ");
        //     System.out.println();
        // }
        return ans;
    }
    
    public boolean rec(String s, String p) {
        if(p.isEmpty()) return s.isEmpty();
        if(s.isEmpty()) {
            for(char c : p.toCharArray()) if(c != '*') return false;
            return true;
        }
        boolean ans = false;
        if(s.charAt(0) == p.charAt(0) || p.charAt(0) == '?') 
            ans = (ans || rec(s.substring(1), p.substring(1)));
        
        if(p.charAt(0) == '*'){
            for(int i = 0; i <= s.length(); i ++) {
                ans = (ans || (rec(s.substring(i), p.substring(1))));
            }
        }
        return ans;
    }
    
    public boolean memo(String s, String p, int i, int j, int[][] dp) {
        if(p.length() == j) {
            dp[i][j] = (s.length() == i) ? 1 : 0;
            return i == s.length();
        }
        if(s.length() == i) {
            for(int x = j; x < p.length(); x ++) {
                char c = p.charAt(x);
                if(c != '*') {
                    dp[i][j] = 0;
                    return false;
                }
            }
            dp[i][j] = 1;
            return true;
        }
        if(dp[i][j] != -1) return dp[i][j] == 1;
        boolean ans = false;
        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') 
            ans = (ans || memo(s, p, i + 1, j + 1, dp));
        
        if(p.charAt(j) == '*'){
            for(int x = 0; x <= s.length() - i; x ++) {
                ans = (ans || (memo(s, p, i + x, j + 1, dp)));
            }
        }
        dp[i][j] = ans ? 1 : 0;
        return ans;
    }
}