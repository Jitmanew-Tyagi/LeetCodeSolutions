class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length, m = mat[0].length, ans[][] = new int[n][m];
        int[][] dirn = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        boolean vis[][] = new boolean[n][m];
        Queue<Integer> que = new LinkedList<>();
        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < m; j ++) {
                if(mat[i][j] == 0) {
                    vis[i][j] = true;
                    que.add(i * m + j);
                }
            }
        }
        
        while(!que.isEmpty()){
            int out = que.remove();
            int x = out / m, y = out % m;
            for(int[] dir : dirn) {
                int nx = x + dir[0], ny = y + dir[1];
                if(nx >= 0 && ny >= 0 && nx < n && ny < m && !vis[nx][ny] && mat[nx][ny] == 1) {
                    vis[nx][ny] = true;
                    ans[nx][ny] = ans[x][y] + 1;
                    que.add(nx * m + ny);
                }
            }
        }
        return ans;
    }
}