class Solution {
    public int[][] transpose(int[][] matrix) {
        int tr = matrix.length, tc = matrix[0].length;
        int[][] transpose = new int[tc][tr];
        
        for(int i = 0; i < tr; i ++) {
            for(int j = 0; j < tc; j ++) {
                transpose[j][i] = matrix[i][j];
            }
        }
        
        return transpose;
    }
}