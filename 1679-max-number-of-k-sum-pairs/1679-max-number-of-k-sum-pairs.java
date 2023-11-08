class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int s = 0, e = nums.length - 1, ans = 0;
        while(s < e) {
            int sum = nums[s] + nums[e];
            if(sum == k) {
                ans ++;
                s ++;
                e--;
            } else if (sum < k) s ++;
            else e --;
        }
        return ans;
    }
}