class Solution {
    public int[][] construct2DArray(int[] one, int p, int q) {
        if(p * q != one.length) return new int[0][0]; 
        int[][] two = new int[p][q];
        int idx = 0;
        for(int r = 0; r < p; r ++) {
            for(int c = 0; c < q; c ++) {
                two[r][c] = one[idx];
                idx ++;
            }
        }
        return two;
    }
}