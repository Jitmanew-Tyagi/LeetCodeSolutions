class Solution {
    public int[] shuffle(int[] nums, int n) {
        int a = 0, b = n, idx = 0;
        int[] ans = new int[2 * n];
        while(idx < ans.length) {
            ans[idx ++] = nums[a ++];
            ans[idx ++] = nums[b ++];
        }
        return ans;
    }
}