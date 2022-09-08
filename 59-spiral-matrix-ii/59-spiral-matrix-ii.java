class Solution {
    public int[][] generateMatrix(int n) {
        int tne = n*n;
        int dirn = 0;
        int sr = 0, sc = 0, er = n - 1, ec = n - 1;  
        int num = 1;
        int[][] board = new int[n][n];
        while (tne -- > 0) {
            if(dirn%4 == 0) {
                for (int i = sc; i <= ec; i++) {
                    board[sr][i] = num++;
                }
                sr ++;
                dirn ++;
            }
            if(dirn%4 == 1) {
                for (int i = sr; i <= er; i++) {
                    board[i][ec] = num ++;
                }
                ec --;
                dirn ++;
            }
            if(dirn%4 == 2) {
                for (int i = ec; i >= sc; i--) {
                    board[er][i] = num ++;
                }
                er --;
                dirn ++;
            }
            if(dirn%4 == 3) {
                for (int i = er; i >= sr; i--) {
                    board[i][sc] = num ++;
                }
                sc ++;
                dirn ++;
            }
        }
        return board;
    }
}