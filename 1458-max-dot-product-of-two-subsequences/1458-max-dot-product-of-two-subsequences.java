class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        if(nums1.length == 0 || nums2.length == 0) return 0;
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        for(int[] d : dp) Arrays.fill(d, -(int)1e6);
        return rec(nums1, nums2, 0, 0, dp);
    }
    
    public int rec(int[] n1, int[] n2, int i, int j, int[][] dp) {
        if(i == n1.length || j == n2.length) {
            return dp[i][j] = -(int)1e6;
        }
        if(dp[i][j] != -(int)1e6) return dp[i][j];
        int self = n1[i] * n2[j];
        int incBoth = rec(n1, n2, i + 1, j + 1, dp) + self;
        int a = rec(n1, n2, i + 1, j, dp);
        int b = rec(n1, n2, i, j + 1, dp);
        return dp[i][j] = getMax(self, incBoth, a, b);
    }
    
    public int getMax(int... arr){
        int max = arr[0];
        for(int i : arr) max = Math.max(i, max);
        return max;
    }
}