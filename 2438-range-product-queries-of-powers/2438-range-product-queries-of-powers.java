class Solution {
    public int[] productQueries(int n, int[][] queries) {
        List<Integer> arl = new ArrayList<>();
        long max = 1;
        while(max * 2 <= n)  max *= 2;
        while(n > 0 && max > 0) {
            if(max > n) {
                max /= 2;
                continue;
            }
            if(max <= n) {
                arl.add(0, (int)max);
                n -= max;
            }
            max /= 2;
        }
        int mod = 1_000_000_007;
        double[] pre = new double[arl.size()];
        pre[0] = arl.get(0);
        for(int i = 1; i < pre.length; i ++) {    
            pre[i] = arl.get(i) * pre[i - 1];
        }
        double[] ans = new double[queries.length];
        for(int i = 0; i < queries.length; i ++) {
            int l = queries[i][0], r = queries[i][1];
            ans[i] = pre[r] / ((l - 1) >= 0 ? pre[l - 1] : 1);
        }
        int[] retAns = new int[ans.length];
        int idx = 0;
        for(double l : ans) retAns[idx ++] = (int)(l % mod);
        return retAns;
    }
}