class Solution {
    public int minOperations(int[] nums, int k) {
        int ans = k, count = 0;
        for(int ele : nums) ans ^= ele;
        return Integer.bitCount(ans);
    }
}