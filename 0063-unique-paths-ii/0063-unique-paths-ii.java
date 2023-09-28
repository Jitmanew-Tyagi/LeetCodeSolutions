class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0] == 1 || obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1) 
            return 0;
        int[][] dirns = {{1, 0}, {0, 1}};
        int[][] dp = new int[obstacleGrid.length + 1][obstacleGrid[0].length + 1];
        for(int[] d : dp) Arrays.fill(d, -1);
        return rec(obstacleGrid, 0, 0, dirns, dp);
    }
    
    public int rec(int[][] maze, int i, int j, int[][] dirns, int[][] dp) {
       for(i = maze.length - 1; i >= 0; i --) {
           for(j = maze[0].length; j >= 0; j --) {
               
               if(i == maze.length - 1 && j == maze[0].length - 1) {
                     dp[i][j] = 1;
                   continue;
               }
               int count = 0;
               for(int[] dir : dirns) 
                    if(i + dir[0] < maze.length && j + dir[1] < maze[0].length && maze[i + dir[0]][j + dir[1]] == 0)
                        count += dp[i + dir[0]][j + dir[1]];
               dp[i][j] = count;
           }
       }
       return dp[0][0];        
    }
}