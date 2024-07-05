class Solution {
    public int maxSubArray(int[] nums) {
        int ans = nums[0], sum = 0;
        for(int ele : nums) {
            sum += ele;
            if(sum > ans) ans = sum;
            if(sum < 0) sum = 0;
        }
        return ans;
    }
}