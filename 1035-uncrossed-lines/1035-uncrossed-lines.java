class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        for(int[] d : dp) Arrays.fill(d, -1);
        return memo(nums1, nums2, 0, 0, dp);
    }
    
    public int rec(int[] a, int[] b, int i, int j) {
        if(i == a.length || j == b.length) return 0;
        if(a[i] == b[j]) return 1 + rec(a, b, i + 1, j + 1);
        return Math.max(rec(a, b, i + 1, j), rec(a, b, i, j + 1));
    }
    
    public int memo(int[] a, int[] b, int i, int j, int[][] dp) {
        if(i == a.length || j == b.length) return dp[i][j] = 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(a[i] == b[j]) return dp[i][j] = 1 + memo(a, b, i + 1, j + 1, dp);
        return dp[i][j] = Math.max(memo(a, b, i + 1, j, dp), memo(a, b, i, j + 1, dp));
    }
}