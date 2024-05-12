class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int[] dp = new int[k];
        Arrays.fill(dp, Integer.MIN_VALUE);
        for(int i = 0; i < energy.length; i ++) {
            int idx = i % k;
            if(dp[idx] < 0) dp[idx] = energy[i];
            else dp[idx] += energy[i];
        }
        int max = Integer.MIN_VALUE;
        for(int ele : dp) if(ele > max) max = ele;
        return max;
    }
}