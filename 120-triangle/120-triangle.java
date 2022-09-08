class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n + 1][n + 1];
        for(int[] ar : dp) Arrays.fill(ar, Integer.MIN_VALUE);
        return helper(triangle, 0, 0, dp);
    }
    
    public int helper(List<List<Integer>> triangle, int idx, int jdx, int[][] dp) {
        if(idx == triangle.size()) return dp[idx][jdx] = 0;
        if(dp[idx][jdx] != Integer.MIN_VALUE) return dp[idx][jdx];
        return dp[idx][jdx] = triangle.get(idx).get(jdx) + 
            Math.min(helper(triangle, idx + 1, jdx, dp), helper(triangle, idx + 1, jdx + 1, dp));
    }
    
}