class Solution {
    public int countHomogenous(String s) {
        int i = 0, n = s.length(), MOD = (int)(1e9 + 7);
        long count = 0;
        int ans = 0;
        while(i < n) {
            if(i == 0 || s.charAt(i) == s.charAt(i - 1)) count ++;
            else {
                ans += ((count * (count + 1)) / 2) % MOD;
                count = 1;
            }
            i ++;
        }
        ans += ((count * (count + 1)) / 2) % MOD;
        return ans % MOD;
    }
}