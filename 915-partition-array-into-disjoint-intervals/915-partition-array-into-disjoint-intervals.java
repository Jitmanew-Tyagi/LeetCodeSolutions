class Solution {
    public int partitionDisjoint(int[] arr) {
        int n = arr.length, min = Integer.MAX_VALUE, chunks = 0, lmax=  -1;
        int[] rmin = new int[n + 1];
        for(int i = n; i > 0; i --)  {
            rmin[i] = min;
            min = Math.min(arr[i - 1], min);
        }
        for(int i = 0; i < n; i ++) {
            lmax = Math.max(lmax, arr[i]);
            if(rmin[i + 1] >= lmax) return i + 1;
        }
        return chunks;
    }
    
}