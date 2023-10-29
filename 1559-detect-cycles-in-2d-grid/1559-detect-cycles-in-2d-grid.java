class Solution {
    public boolean containsCycle(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < m; j ++) {
                if(!vis[i][j]) if(BFS(grid, i, j, n, m, vis)) return true;
            }
        }
        return false;
    }
    
    public boolean BFS(char[][] grid, int i, int j, int n, int m, boolean[][] vis) {
        Queue<Integer> que = new LinkedList<>();
        que.add(i * m + j);
        int[][] dirn = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        while(!que.isEmpty()) {
            int out = que.remove();
            int ti = out / m, tj = out % m;
            if(vis[ti][tj]) return true;
            vis[ti][tj] = true;
            for(int[] dir : dirn) {
                int x = ti + dir[0], y = tj + dir[1];
                if(x >= 0 && y >= 0 && x < n && y < m && grid[x][y] == grid[ti][tj] && !vis[x][y]) 
                    que.add(x * m + y);
            }
        }
        return false;
    }
}