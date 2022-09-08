class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        par = new int[m * n];
        size = new int[n * m];
        
        for(int i = 0; i < n * m; i ++) {
            par[i] = i;
            size[i] = 1;
        }
        int[][] dirn = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < m; j ++) {
                if(grid[i][j] == 1) {
                    int p1 = findPar(i * m + j);
                    for(int[] dir : dirn){
                        int x = i + dir[0], y = j + dir[1];
                        if(x >= 0 && y >= 0 && x < n && y < m && grid[x][y] == 1) {
                            int p2 = findPar(x * m + y);
                            if(p1 != p2) {
                                par[p2] = p1;
                                size[p1] += size[p2];
                            }
                        }
                    }
                }
            }
        }
        int maxSize = 0;
        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < m; j ++) {
                if(grid[i][j] == 1 && par[i * m + j] == i * m + j) maxSize = Math.max(size[i * m + j], maxSize);
            }
        }
        return maxSize;
    }
    
    int[] par, size;
    
    public int findPar(int v) {
        return par[v] == v ? v : (par[v] = findPar(par[v]));
    }
}