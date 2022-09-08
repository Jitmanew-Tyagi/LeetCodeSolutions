class Solution {
    public int maxArea(int[] height) {
        int mtn = 0, l = 0, r = height.length - 1;
        while(l < r) {
            mtn = Math.max(mtn, (r - l) * Math.min(height[l], height[r]));
            if(height[l] < height[r]) l ++;
            else r --;
        } 
        return mtn;
    }
}