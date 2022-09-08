class Solution {
    public int maxChunksToSorted(int[] arr) {
        int idx = 0, n = arr.length, max = arr[0], chunks = 0;
        if(n == 1) return n;
        while(idx < n) {
            max = Math.max(max, arr[idx]);
            if(idx ++ == max) {
                chunks ++;
            }
        }
        return chunks;
    }
}