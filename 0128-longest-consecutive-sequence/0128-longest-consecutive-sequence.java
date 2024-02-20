class Solution {
    public int longestConsecutive(int[] nums) {
        int maxLength = 0;
        Set<Integer> hs = new HashSet<>();
        for(int ele : nums) hs.add(ele);
        for(int ele : nums) {
            int lo = ele, hi = ele;
            while(hs.contains(lo - 1)) {
                lo = lo - 1;
                hs.remove(lo);
            }
            
            while(hs.contains(hi + 1)) {
                hi = hi + 1;
                hs.remove(hi);
            }
            
            int tl = hi - lo + 1;
            maxLength = Math.max(tl, maxLength);
        }
        return maxLength;
    }
}