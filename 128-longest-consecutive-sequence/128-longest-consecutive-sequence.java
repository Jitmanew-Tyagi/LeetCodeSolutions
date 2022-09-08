class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        HashSet<Integer> hs = new HashSet<>();
        for(int i : nums) hs.add(i);
        int ans = 0;
        for(int i : nums) {
            int lo = i, hi = i;
            if(hs.contains(i)) {
                while(hs.contains(lo - 1)) {
                    lo = lo - 1;
                    hs.remove(lo);
                }
                while(hs.contains(hi + 1)) {
                    hi = hi + 1;
                    hs.remove(hi);
                }
                ans = Math.max(ans, hi - lo + 1);
            }
        }
        return ans;
    }
}