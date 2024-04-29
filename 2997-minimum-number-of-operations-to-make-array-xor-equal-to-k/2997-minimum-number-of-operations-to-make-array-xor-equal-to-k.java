class Solution {
    public int minOperations(int[] nums, int k) {
        int ans = k, count = 0;
        for(int ele : nums) ans ^= ele;
        for(int i = 0; i < 32; i ++) count += (ans & (1 << i)) > 0 ? 1 : 0;
        return count;
    }
}