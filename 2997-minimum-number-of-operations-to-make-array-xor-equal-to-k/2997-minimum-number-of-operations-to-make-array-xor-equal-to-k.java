class Solution {
    public int minOperations(int[] nums, int k) {
        int ans = 0;
        for(int ele : nums) ans ^= ele;
        ans ^= k;
        int count = 0;
        for(int i = 0; i < 32; i ++) {
            int mask = 1 << i;
            count += (ans & mask) > 0 ? 1 : 0;
        }
        return count;
    }
}