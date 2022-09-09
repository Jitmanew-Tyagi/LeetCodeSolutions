class Solution {
    public List<Integer> getRow(int n) {
        Integer[] ans = new Integer[n + 1];
        Arrays.fill(ans, 0);
        ans[0] = 1;
        for(int i = 1; i <= n; i ++) 
            for(int j = i; j > 0; j --) ans[j] = ans[j] + ans[j - 1];
        return Arrays.asList(ans);   
    }
}