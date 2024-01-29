class Solution {
    public int[][] transpose(int[][] matrix) {
        int tr = matrix.length, tc = matrix[0].length;
        int[][] ans = new int[tc][tr];
        for(int r = 0; r < tr; r ++) {
            for(int c = 0; c < tc; c ++) {
                ans[c][r] = matrix[r][c];
            }
        }
        return ans;
    }
}