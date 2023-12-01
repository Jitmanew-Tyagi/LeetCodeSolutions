class Solution {
    public int[][] differenceOfDistinctValues(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] ans = new int[n][m];
        
        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < m; j ++) {
                ans[i][j] = Math.abs(leftDiag(grid, i, j) - rightDiag(grid, i, j));
            }
        }
        
        return ans;
    }
    
    public int leftDiag(int[][] grid, int i, int j) {
        HashSet<Integer> hs=  new HashSet();
        i --; j --;
        while(i >= 0 && j >= 0) hs.add(grid[i --][j --]);
        return hs.size();
    }
    
    public int rightDiag(int[][] grid, int i, int j) {
        HashSet<Integer> hs=  new HashSet();
        i ++; j ++;
        while(i < grid.length && j < grid[0].length) hs.add(grid[i ++][j ++]);
        return hs.size();
    }
}