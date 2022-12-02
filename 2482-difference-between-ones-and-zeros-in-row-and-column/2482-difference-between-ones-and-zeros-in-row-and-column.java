class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[] rc = new int[n], cc = new int[m];
        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < m; j ++) {
                rc[i] += grid[i][j];
                cc[j] += grid[i][j];
            }
        }
        
        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < m; j ++) {
                grid[i][j] = rc[i] + rc[i] - n + cc[j] + cc[j] - m;
            }
        }
        
        return grid;
    }
}