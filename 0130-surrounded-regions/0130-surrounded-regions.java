class Solution {
    public void solve(char[][] board) {
        int n = board.length, m = board[0].length;
        boolean[][] vis = new boolean[n][m];
        int[][] dirn = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        for(int i = 0; i < n; i ++) {
            if(board[i][m - 1] == 'O') DFS(board, i, m - 1, vis, dirn);
            if(board[i][0] == 'O') DFS(board, i, 0, vis, dirn);
        }
        
        for(int i = 0; i < m; i ++) {
            if(board[0][i] == 'O') DFS(board, 0, i, vis, dirn);
            if(board[n - 1][i] == 'O') DFS(board, n - 1, i, vis, dirn);
        }
        
        fixBoard(board);
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
    
    public void fixBoard(char[][] board) {
        for(int i = 0; i < board.length; i ++) {
            for(int j = 0; j < board[0].length; j ++) {
                if(board[i][j] == 'O') board[i][j] = 'X';
                else if(board[i][j] == '#') board[i][j] = 'O';
            }
        }
    }
}