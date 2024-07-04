class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> hs = new HashSet<>();
        for(int ele : nums) hs.add(ele);
        int ans = 0;
        for(int ele : nums) {
            int lo = ele - 1, hi = ele + 1;
            while(hs.contains(lo)) {
                hs.remove(lo);
                lo --;
            }
            
            while(hs.contains(hi)) {
                hs.remove(hi);
                hi ++;
            }
            int len = hi - lo - 1;
            if(len > ans) ans = len;
        }
        return ans;
    }
}