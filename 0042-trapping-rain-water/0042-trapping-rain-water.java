class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int totalWater = 0;
        int[] left = getLB(height);
        int[] right = getRB(height);
        for(int bar = 0; bar < n; bar ++) {
            int bh = height[bar];
            int lb = left[bar], rb = right[bar];
            int water = Math.min(lb, rb) - bh;
            if(water > 0) totalWater += water;
        }
        return totalWater;
    }
    
    public int[] getLB(int[] bars) {
        int n = bars.length;
        int[] ans = new int[n];
        int lb = 0;
        for(int i = 0; i < n; i ++) {
            ans[i] = lb;
            if(bars[i] > lb) lb = bars[i];
        }
        return ans;
    }
    
    public int[] getRB(int[] bars) {
        int n = bars.length;
        int[] ans = new int[n];
        int rb = 0;
        for(int i = n - 1; i >= 0; i --) {
            ans[i] = rb;
            if(bars[i] > rb) rb = bars[i];
        }
        return ans;
    }
}