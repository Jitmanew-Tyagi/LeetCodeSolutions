class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        Pair[] ans = new Pair[(n * (n - 1)) / 2];
        int idx = 0;
        for(int i = 0; i < n; i ++) {
            for(int j = i  + 1; j < n; j ++) {
                ans[idx ++] = new Pair(arr[i], arr[j]);
            }
        }
        Arrays.sort(ans);
        return new int[] {ans[k - 1].n, ans[k - 1].d};
    }
    
    class Pair implements Comparable<Pair> {
        int n;
        int d;
        
        Pair(int n, int d) {
            this.n = n;
            this.d = d;
        }
        
        public int compareTo(Pair other) {
            return ((this.n * 1.0) / this.d) - ((other.n * 1.0) / other.d) > 0 ? 1 : -1;
        }
    }
}