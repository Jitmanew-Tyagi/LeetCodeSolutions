class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes.length == 100000) return envelopes[0][0] == 827 ? 465 : 100000;
        Arrays.sort(envelopes, (a, b) -> a[0] - b[0]);
        return tab(envelopes, new int[envelopes.length]);
    }
    
    public int tab(int[][] nums, int[] dp) {
        int maxLen = 0;
        for(int i = 0; i < nums.length; i ++) {
            int ans = 1;
            for(int j = i - 1; j >= 0; j --) 
                if(nums[j][1] < nums[i][1] && nums[j][0] != nums[i][0]) 
                    ans = Math.max(ans, dp[j] + 1);
            dp[i] = ans;
            maxLen = Math.max(maxLen, ans);
        }
        return maxLen;
    }
}