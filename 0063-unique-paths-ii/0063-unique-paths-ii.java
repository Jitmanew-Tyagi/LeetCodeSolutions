class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        // return rec(0, 0, obstacleGrid);
        int[][] dp = new int[grid.length + 1][grid[0].length + 1];
        for(int[] d : dp) Arrays.fill(d, -1);
        return memo(0, 0, grid, dp);
    }
    
    public int rec(int i, int j, int[][] grid) {
        if(i >= grid.length || j >= grid[0].length || grid[i][j] == 1) return 0;
        if(i == grid.length - 1 && j == grid[0].length - 1) return 1;
        int ans = 0;
        ans += rec(i + 1, j, grid);
        ans += rec(i, j + 1, grid);
        return ans;
    }
    
    public int memo(int i, int j, int[][] grid, int[][] dp) {
        if(i >= grid.length || j >= grid[0].length || grid[i][j] == 1) return dp[i][j] = 0;
        if(i == grid.length - 1 && j == grid[0].length - 1) return dp[i][j] = 1;
        if(dp[i][j] != -1) return dp[i][j];
        int ans = 0;
        ans += memo(i + 1, j, grid, dp);
        ans += memo(i, j + 1, grid, dp);
        return dp[i][j] = ans;
    }
}