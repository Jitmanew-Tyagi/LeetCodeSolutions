class Solution {
    public int lengthOfLIS(int[] nums) {
        // return lisRec(nums, 0, new ArrayList<Integer>());
        int ans = 0; 
        int[] dp = new int[nums.length + 1];
        for(int i = 0; i < nums.length; i ++) {
            ans = Math.max(ans, memo(nums, i, dp));
        }
        return ans;
    }
    
    public int lisRec(int[] nums, int i, List<Integer> curr) {
        if(i == nums.length) return curr.size();
        int inc = 0, exc = 0;
        if(curr.size() == 0 || curr.get(curr.size() - 1) < nums[i]) {
            curr.add(nums[i]);
            inc = lisRec(nums, i + 1, curr);
            curr.remove(curr.size() - 1);
        }
        exc = lisRec(nums, i + 1, curr);
        return Math.max(inc, exc);
    }
    
    public int memo(int[] nums, int ei, int[] dp) {
        int maxLen = 1;
        if(dp[ei] != 0) return dp[ei];
        for(int i = ei; i >= 0; i --) {
            if(nums[i] < nums[ei]) {
                int len = memo(nums, i, dp);
                maxLen = Math.max(maxLen, len + 1);
            }
        }
        return dp[ei] = maxLen;
    }
}