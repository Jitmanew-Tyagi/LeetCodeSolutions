class Solution {
    public int longestContinuousSubstring(String s) {
        int n = s.length(), len = 1, ans = 0;
        for(int i = 1; i < n ; i ++)  {
            if(s.charAt(i) == s.charAt(i - 1) + 1) len ++;
            else {
                ans = len > ans ? len : ans;
                len = 1;
            }
        }
        ans = len > ans ? len : ans;
        return ans;
    }
}