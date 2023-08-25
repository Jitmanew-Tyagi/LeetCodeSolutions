class Solution {
    public void rotate(int[][] matrix) {
        transpose(matrix);
        reverseRows(matrix);
    }
    
    public void transpose(int[][] arr) {
        for(int r = 0; r < arr.length; r ++) {
            for(int c = r; c < arr.length; c ++) {
                swapTranspose(arr, r, c);
            }
        }
    }
    
    public void swapTranspose(int[][] arr, int r, int c){
        int temp = arr[r][c];
        arr[r][c] = arr[c][r];
        arr[c][r] = temp;
    }
    
    public void reverseRows(int[][] arr) {
        for(int r = 0; r < arr.length; r ++) {
            int s = 0, e = arr.length - 1;
            while(s < e) {
                swapRow(arr, r, s, e);
                s ++;
                e --;
            }
        }
    }
    
    public void swapRow(int[][] arr, int r, int s, int e){
        int temp = arr[r][s];
        arr[r][s] = arr[r][e];
        arr[r][e] = temp;
    }
    
}