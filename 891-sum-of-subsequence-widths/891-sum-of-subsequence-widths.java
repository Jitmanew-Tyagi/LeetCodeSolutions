class Solution {
    public int sumSubseqWidths(int[] nums) {
        int n = nums.length;
        long ans = 0, mod = ((int)1e9 + 7), powers[] = new long[n];
        Arrays.sort(nums);
        for(int i = 0; i < n; i ++) powers[i] = i == 0 ? 1 : (powers[i - 1] * 2) % mod;
        for(int i = 0; i < n; i ++) ans = (ans + nums[i] * (powers[i] - powers[n - i - 1])) % mod;
        return (int)(ans % mod);
    }
}