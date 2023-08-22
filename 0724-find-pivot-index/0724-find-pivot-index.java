class Solution {
    public int pivotIndex(int[] arr) {
        int n = arr.length, sum = 0;
        int[] nums = new int[n];
        for(int i = 0; i < n; i ++) {
            sum += arr[i];
            nums[i] = sum;
        }
        if(nums[n - 1] - nums[0] == 0) return 0;
        for(int i = 1; i < n; i ++) if(nums[i - 1] == nums[n - 1] - nums[i]) return i;
        if(n > 1 && nums[n - 2] == 0) return n - 1;
        return -1;
    }
}