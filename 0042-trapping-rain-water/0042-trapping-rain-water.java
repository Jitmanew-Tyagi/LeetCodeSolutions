class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int totalWater = 0;
        for(int bar = 0; bar < n; bar ++) {
            int bh = height[bar];
            int lb = 0, rb = 0;
            for(int i = bar - 1; i >= 0; i --) {
                if(lb < height[i]) lb = height[i];
            }
            
            for(int i = bar + 1; i < n; i ++) {
                if(rb < height[i]) rb = height[i];
            }
            
            int water = Math.min(lb, rb) - bh;
            if(water > 0) totalWater += water;
        }
        return totalWater;
    }
}