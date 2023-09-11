class Solution {
    public int countBinarySubstrings(String s) {
        int bt = 0, n = s.length(), count = 1;
        int[] batches = new int[n];
        for(int i = 1; i < n; i ++) {
            if(s.charAt(i) == s.charAt(i - 1)) {
                count ++;
            } else {
                batches[bt] = count;
                bt ++;
                count = 1;
            }
        }
        batches[bt] = count;
        int ans = 0;
        for(int i = 1; i <= bt; i ++) {
            ans += Math.min(batches[i], batches[i - 1]);
        }
        return ans;
    }
}