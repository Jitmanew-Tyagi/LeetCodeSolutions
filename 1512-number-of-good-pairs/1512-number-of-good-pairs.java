class Solution {
    public int numIdenticalPairs(int[] nums) {
        int hm[] = new int[101], ans = 0;
        for(int ele : nums) {
            ans += hm[ele];
            hm[ele] ++;
        }
        return ans;
    }
}