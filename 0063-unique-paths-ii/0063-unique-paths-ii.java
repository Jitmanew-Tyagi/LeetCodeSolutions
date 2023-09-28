class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dirns = {{1, 0}, {0, 1}};
        int[][] dp = new int[obstacleGrid.length + 1][obstacleGrid[0].length + 1];
        for(int[] d : dp) Arrays.fill(d, -1);
        return rec(obstacleGrid, 0, 0, dirns, dp);
    }
    
    public int rec(int[][] maze, int i, int j, int[][] dirns, int[][] dp) {
        if(i >= maze.length || j >= maze[0].length || maze[i][j] == 1) 
            return dp[i][j] = 0;
        if(i == maze.length - 1 && j == maze[0].length - 1) 
            return dp[i][j] = 1;
        if(dp[i][j] != -1) return dp[i][j];
        int count = 0;
        for(int[] dir : dirns) 
            count += rec(maze, i + dir[0], j + dir[1], dirns, dp);
        return dp[i][j] = count;
    }
}