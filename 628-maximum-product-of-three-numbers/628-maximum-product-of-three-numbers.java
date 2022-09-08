class Solution {
    public int maximumProduct(int[] nums) {
        int mx1 = Integer.MIN_VALUE, mx2 = mx1, mx3 = mx1, mn1 = Integer.MAX_VALUE, mn2 = mn1;
        for(int i : nums) {
            if(i > mx1) {
                mx3 = mx2;
                mx2 = mx1;
                mx1 = i;
            }
            else if(i > mx2) {
                mx3 = mx2;
                mx2 = i;
            }
            else if(i > mx3) mx3 = i;
            if(i < mn1) {
                mn2 = mn1;
                mn1 = i;
            }
            else if(i < mn2) mn2 = i;
        }
        return Math.max(mx1 * mx2 * mx3, mx1 * mn1 * mn2);
    }
}