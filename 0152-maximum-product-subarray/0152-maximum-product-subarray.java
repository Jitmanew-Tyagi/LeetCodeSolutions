class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length, cprod = 1, maxProd = Integer.MIN_VALUE;
        for(int i = 0; i < n; i ++) {
            cprod *= nums[i];
            if(cprod > maxProd) maxProd = cprod;
            if(cprod == 0) cprod = 1;
        }
        cprod = 1;
        for(int i = n - 1; i >= 0; i --) {
            cprod *= nums[i];
            if(cprod > maxProd) maxProd = cprod;
            if(cprod == 0) cprod = 1;
        }
        return maxProd;
    }
}