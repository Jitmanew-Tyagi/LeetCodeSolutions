class Solution {
    public int[] productExceptSelf(int[] nums) {
        int temp = 1, n = nums.length;
        int[] ans = new int[n];
        for(int i = 0; i < n; i ++) {
            ans[i] = temp;
            temp *= nums[i];
        }
        temp = 1;
        for(int i = n - 1; i >= 0; i --) {
            ans[i] *= temp;
            temp *= nums[i];
        }
        return ans;
    }
}