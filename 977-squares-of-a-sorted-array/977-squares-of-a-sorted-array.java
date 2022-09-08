class Solution {
    public int[] sortedSquares(int[] nums) {
        int i = 0, j = nums.length - 1, ansIdx = j + 1;
        int[] ans = new int[nums.length];
        while(ansIdx --> 0) {
            if(sq(nums[i]) < sq(nums[j])) {
                ans[ansIdx] = sq(nums[j --]);
            } else {
                ans[ansIdx] = sq(nums[i ++]);
            }
        }
        return ans;
    }
    public int sq(int i){
        return i*i;
    }
}