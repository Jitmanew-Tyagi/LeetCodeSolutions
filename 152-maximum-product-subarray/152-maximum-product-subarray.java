class Solution {
    public int maxProduct(int[] nums) {
        int ans = Integer.MIN_VALUE, cprod = 1;
        for(int i : nums) {
            cprod *= i;
            ans = Math.max(cprod, ans);
            if(cprod == 0) cprod = 1;
        }
        cprod = 1;
        for(int x = nums.length - 1; x >= 0; x --) {
            int i = nums[x];
            cprod *= i;
            ans = Math.max(cprod, ans);
            if(cprod == 0) cprod = 1;
        } 
        return ans;
    }
}