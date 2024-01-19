class Solution {
    public int[] shuffle(int[] nums, int n) {
        int f = 0, s = nums.length / 2;
        int idx = 0;
        int[] ans = new int[nums.length];
        while(s < nums.length) {
            ans[idx ++] = nums[f ++];
            ans[idx ++] = nums[s ++];         
        }
        return ans;
    }
}