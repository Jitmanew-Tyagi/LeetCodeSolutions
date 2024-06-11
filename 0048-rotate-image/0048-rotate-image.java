class Solution {
    public void rotate(int[][] matrix) {
        transpose(matrix);
        reverseRows(matrix);
    }
    
    public void transpose(int[][] arr) {
        int n = arr.length;
        for(int i = 0; i < n; i ++) {
            for(int j = i + 1; j < n; j ++) {
                swap(arr, i, j, j, i);
            }
        }
    }
    
    public void reverseRows(int[][] arr) {
        for(int r = 0; r < arr.length; r ++) {
            int s = 0, e = arr[0].length - 1;
            while(s <= e) {
                swap(arr, r, s ++, r, e --);
            }
        }
    }
    
    public void swap(int[][] arr, int r1, int c1, int r2, int c2) {
        int temp = arr[r1][c1];
        arr[r1][c1] = arr[r2][c2];
        arr[r2][c2] = temp;
    }
}