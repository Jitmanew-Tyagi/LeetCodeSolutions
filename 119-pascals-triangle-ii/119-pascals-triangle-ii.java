class Solution {
    public List<Integer> getRow(int n) {
        int[][] ans = new int[2][n + 1];
        ans[0][0] = 1;
        for(int j = 0; j < n; j ++) {
            for(int i = 0; i <= n; i ++) {
                ans[1][i] = i == 0 ? ans[0][i] : ans[0][i - 1] + ans[0][i];
            }
            ans[0] = ans[1];
            ans[1] = new int[ans[1].length];
        }
        List<Integer> fans = new ArrayList<>();
        for(int i : ans[0]) fans.add(i);
        return fans;
        
    }
}