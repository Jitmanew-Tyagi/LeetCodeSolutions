class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int count = 0;
        for(int i = 0; i < nums.length; i ++) {
            int csum = 0;
            for(int j = i; j < nums.length; j ++) {
                csum += nums[j];
                if(csum == goal) count ++;
            }
        }
        return count;
    }
}