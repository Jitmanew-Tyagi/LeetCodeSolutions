class Solution {
    public int maxSubArray(int[] nums) {
        int ans = -(int)1e9, sum = 0;
        for(int i : nums) {
            sum += i;
            ans = Math.max(ans, sum);
            if(sum < 0) sum = 0;
        }
        return ans;
    }
}