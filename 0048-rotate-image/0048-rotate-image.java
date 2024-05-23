class Solution {
    public void rotate(int[][] matrix) {
        transpose(matrix);
        for(int[] row : matrix) reverse(row);
    }
    
     public static void transpose(int[][] arr) {
        int n = arr.length;
        for(int i = 0; i < n; i ++) {
            for(int j = i; j < n; j ++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
    } 
    
    public void reverse(int[] arr) {
        int s = 0, e = arr.length - 1;
        while(s < e) {
            int temp = arr[e];
            arr[e] = arr[s];
            arr[s] = temp;
            s ++;
            e --;
        }
    }
}