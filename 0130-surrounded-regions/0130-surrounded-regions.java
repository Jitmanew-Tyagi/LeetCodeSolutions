class Solution {
    public void solve(char[][] board) {
//         int n = board.length, m = board[0].length;
//         boolean[][] vis = new boolean[n][m];
//         int[][] dirn = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
//         for(int i = 0; i < n; i ++) {
//             if(board[i][m - 1] == 'O') DFS(board, i, m - 1, vis, dirn);
//             if(board[i][0] == 'O') DFS(board, i, 0, vis, dirn);
//         }
        
//         for(int i = 0; i < m; i ++) {
//             if(board[0][i] == 'O') DFS(board, 0, i, vis, dirn);
//             if(board[n - 1][i] == 'O') DFS(board, n - 1, i, vis, dirn);
//         }
        
//         fixBoard(board);
        BFS(board);
    }
    
    public void DFS(char[][] board, int i, int j, boolean[][] vis, int[][] dirn) {
        board[i][j] = '#';
        vis[i][j] = true;
        for(int[] dir : dirn) {
            int nx = i + dir[0], ny = j + dir[1];
            if(nx >= 0 && ny >= 0 && nx < board.length && ny < board[0].length && !vis[nx][ny] && board[nx][ny] == 'O') {  
                DFS(board, nx, ny, vis, dirn);
            }
        }
    }
    
    
    public void BFS(char[][] board) {
        int n = board.length, m = board[0].length;
        boolean[][] vis = new boolean[n][m];
        int[][] dirn = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        Queue<Integer> que = new LinkedList<>();
        for(int i = 0; i < n; i ++) {
            if(board[i][m - 1] == 'O') que.add((i * m)+ (m - 1));
            if(board[i][0] == 'O') que.add(i * m);
        }
        
        for(int i = 0; i < m; i ++) {
            if(board[0][i] == 'O') que.add(i);
            if(board[n - 1][i] == 'O') que.add((n - 1) * m + i);
        }
        
        while(!que.isEmpty()){
            int out = que.remove();
            int x = out / m, y = out % m;
            vis[x][y] = true;
            board[x][y] = '#';
            for(int[] dir : dirn) {
                int nx = x + dir[0], ny = y + dir[1];
                if(nx >= 0 && ny >= 0 && nx < n && ny < m && !vis[nx][ny] && board[nx][ny] == 'O') {
                    que.add(nx * m + ny);
                }
            }
        }
        fixBoard(board);
    }
    
    public void fixBoard(char[][] board) {
        for(int i = 0; i < board.length; i ++) {
            for(int j = 0; j < board[0].length; j ++) {
                if(board[i][j] == 'O') board[i][j] = 'X';
                else if(board[i][j] == '#') board[i][j] = 'O';
            }
        }
    }
}