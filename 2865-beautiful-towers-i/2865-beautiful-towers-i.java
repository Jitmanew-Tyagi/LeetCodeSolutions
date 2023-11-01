class Solution {
    public long maximumSumOfHeights(List<Integer> mh) {
        long ans = 0;
        for(int mi = 0; mi < mh.size(); mi ++) {
            long sum = 0;
            int ml = mh.get(mi), mr = ml;
            for(int i = mi; i >= 0; i --) {
                if(mh.get(i) < ml) ml = mh.get(i);
                sum += ml;
            }

            for(int i = mi + 1; i < mh.size(); i ++) {
                if(mh.get(i) < mr) mr = mh.get(i);
                sum += mr;
            }
            ans = Math.max(sum, ans);
        }
        return ans;
    }
}