class Solution {
    public int timeRequiredToBuy(int[] t, int k) {
        int ans = 0;
        for(int i = 0; i < t.length; i ++) 
            ans += Math.min(i <= k ? t[k] : t[k] - 1, t[i]);
        return ans;
    }
}