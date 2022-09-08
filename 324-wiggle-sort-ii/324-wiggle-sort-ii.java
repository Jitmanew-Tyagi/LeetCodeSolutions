class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] ans = new int[n];
        int idx = 1, j = n - 1;
        while(idx < n) {
            ans[idx] = nums[j --];
            idx += 2;
        }
        idx = 0;
        while(idx < n) {
            ans[idx] = nums[j --];
            idx += 2;
        }
        for(int i = 0; i < n; i ++) nums[i] = ans[i];
    }
}