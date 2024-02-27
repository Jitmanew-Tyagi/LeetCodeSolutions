class Solution {
    public long maximumSumOfHeights(List<Integer> mh) {
        long ans = -1;
        for(int b = 0; b < mh.size(); b ++) {
            int ch = mh.get(b), lm = ch, rm = ch;
            long tf = ch;
            for(int i = b - 1; i >= 0; i --) {
                if(mh.get(i) < lm) lm = mh.get(i);
                tf += lm;
            }
            
            for(int i = b + 1; i < mh.size(); i ++) {
                if(mh.get(i) < rm) rm = mh.get(i);
                tf += rm;
            }
            
            ans = Math.max(tf, ans);
        }
        return ans;
    }
}