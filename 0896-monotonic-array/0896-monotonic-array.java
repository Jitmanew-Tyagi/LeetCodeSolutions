class Solution {
    public boolean isMonotonic(int[] nums) {
        boolean a1 = true;
        for(int i = 0; i < nums.length - 1; i ++) 
            a1 = a1 & (nums[i] <= nums[i + 1]);
        if(a1) return a1;
        a1 = true;
        for(int i = nums.length - 1; i >= 1; i --) 
            a1 = a1 & (nums[i] <= nums[i - 1]);
        return a1;
    }
    
}