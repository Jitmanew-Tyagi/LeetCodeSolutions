class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length, dp[] = new int[n], ans = 0;
	    int len = tab(nums, dp);
	    // for(int l : dp) {
	    // System.out.print(l + " ");
	    // if(l == len) ans ++;
	    // }
	    // return ans;
        return tab(nums, dp);
    }
    
    public int tab(int[] nums, int[] dp) {
        int maxLen = 0, lengths[] = new int[dp.length], maxLenIdx = 0;
        Arrays.fill(lengths, 1);
        for(int i = 0; i < nums.length; i ++) {
            int ans = 1;
            for(int j = i - 1; j >= 0; j --) {
                if(nums[j] < nums[i]) {
                    int newLength = dp[j] + 1;
                    if(newLength == ans) lengths[i] += lengths[j];
                    else if(newLength > ans) {
                        ans = newLength;
                        lengths[i] = lengths[j];
                    }
                }
            }
            dp[i] = ans;
            if(ans > maxLen) {
                maxLen = ans;
                maxLenIdx = i;
            }
        }
        int maxLenEq = 0, temp = 0;
        for(int i = 0; i < dp.length; i ++) {
            if(dp[i] == maxLen) temp += lengths[i];
        }
        return temp;
    }
}