class Solution {
    public int maxProductDifference(int[] nums) {
        int mx = -1, smx = -1;
        for(int i : nums) {
            if(i > mx) {
                smx = mx;
                mx = i;
            } else if(i > smx) smx = i;
        }
        
        int mn = 10001, smn = 10001;
        for(int i : nums) {
            if(i < mn) {
                smn = mn;
                mn = i;
            } else if(i < smn) smn = i;
        }
        
        return (mx * smx) - (mn * smn);
    }
}