class Solution {
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        for(int i = 0; i < m; i ++) if(board[i][0] == 'O') consume(board, i, 0);
        for(int i = 0; i < m; i ++) if(board[i][n - 1] == 'O') consume(board, i, n - 1);
        for(int i = 0; i < n; i ++) if(board[0][i] == 'O') consume(board, 0, i);
        for(int i = 0; i < n; i ++) if(board[m - 1][i] == 'O') consume(board, m - 1, i);
        convert(board, m, n);
    }
    
    public void consume(char[][] board, int i, int j) {
        
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == 'X' || board[i][j] == '$') return;
        // System.out.println("Called");
        board[i][j] = '$';
        consume(board, i - 1, j);
        consume(board, i + 1, j);
        consume(board, i, j - 1);
        consume(board, i, j + 1);
    }
    
    public void convert(char[][] board, int n, int m) {
        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < m; j ++) {
                if(board[i][j] == 'O') board[i][j] = 'X';
                else if(board[i][j] == '$') board[i][j] = 'O';
            }
        }
    }
}