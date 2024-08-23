class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length, ans[] = new int[n];
        int prod = 1, noz = 0;
        for(int ele : nums) {
            if(ele == 0) noz ++;
            else prod *= ele;
        }
        
        if(noz > 1) return ans;
        if(noz == 1) {
            for(int i = 0; i < n; i ++) {
                ans[i] = nums[i] == 0 ? prod : 0;
            }
        } else {
            for(int i = 0; i < n; i ++) {
                ans[i] = prod / nums[i];
            }
        }
        return ans;
    }
}