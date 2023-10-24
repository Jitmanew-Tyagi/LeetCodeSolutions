class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length, dp[] = new int[n], lengths[] = new int[n];
        Arrays.fill(lengths, 1);
        int maxLen = 0, maxCount = 0;
        for(int i = 0; i < n; i ++) {
            int len = 1;
            for(int j = i - 1; j >= 0; j --) {
                if(nums[j] >= nums[i]) continue;
                int newLen = dp[j] + 1;
                if(newLen > len) {
                    len = newLen;
                    lengths[i] = lengths[j];
                } else if(newLen == len) {
                    lengths[i] += lengths[j];
                }
            }
            dp[i] = len;
            maxLen = Math.max(dp[i], maxLen);
        }
        for(int i = 0; i < n; i ++) 
            if(dp[i] == maxLen) maxCount += lengths[i];
        return maxCount;  
    }
    
    
}