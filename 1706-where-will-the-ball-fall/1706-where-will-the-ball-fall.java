class Solution {
    public int[] findBall(int[][] grid) {
        int n = grid.length, m = grid[0].length, ans[] = new int[m];
        for(int b = 0; b < m; b ++) {
            int ocol = b;
            for(int i = 0; i < n; i ++) {
                int ncol = ocol + grid[i][ocol];
                if(ncol < 0 || ncol == m || grid[i][ocol] != grid[i][ncol]) {
                    ocol = -1;
                    break;
                }
                ocol = ncol;
            }
            ans[b] = ocol;
        }
        return ans;
    }
}