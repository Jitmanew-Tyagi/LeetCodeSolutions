class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        rec(numRows, ans);
        return ans;
    }
    
    public List<Integer> rec(int n, List<List<Integer>> ans) {
        if(n == 1) {
            List<Integer> base = new ArrayList<>();
            base.add(1);
            ans.add(base);
            return base;
        }
        List<Integer> faith = rec(n - 1, ans);
        List<Integer> exp = new ArrayList<>();
        exp.add(1);
        for(int i = 0; i < faith.size() - 1; i ++) 
            exp.add(faith.get(i) + faith.get(i + 1));
        exp.add(1);
        ans.add(exp);
        return exp;
    }
}