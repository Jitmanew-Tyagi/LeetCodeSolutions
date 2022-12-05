class Solution {
    public int pivotInteger(int n) {
        int stn = (n * (n + 1)) / 2;
        for(int i = 1; i <= n; i ++) {
            int sti = (i * (i + 1))/2;
            if(sti == (stn - sti + i)) return i;
        }
        return -1;
    }
}