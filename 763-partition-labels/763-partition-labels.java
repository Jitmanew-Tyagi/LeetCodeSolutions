class Solution {
    public List<Integer> partitionLabels(String str) {
        int n = str.length(), s = 0, e = 0, trav = s, nos = 0;
        List<Integer> ans = new ArrayList<>();
        int[] loc = new int[26];
        for(int i = 0; i < n; i ++) {
            loc[str.charAt(i) - 'a'] = i;
        }
        e = loc[str.charAt(s) - 'a'];
        while(s < n) {
            if(trav == e) {
                ans.add(trav + 1);
                s = e + 1;
                trav = s;
                if(trav >= n) break;
                e = loc[str.charAt(trav) - 'a'];
            }
            while(trav < e) {
                e = Math.max(loc[str.charAt(trav) - 'a'], e);
                trav ++;
            }
        }
        List<Integer> x = new ArrayList<>();
        x.add(ans.get(0));
        for(int i = 1; i < ans.size(); i ++) x.add(ans.get(i) - ans.get(i - 1));
        return x;
    }
}