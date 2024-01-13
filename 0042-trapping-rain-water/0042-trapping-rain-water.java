class Solution {
    public int trap(int[] height) {
        int water = 0;
        for(int i = 0; i < height.length; i ++) {
            int lb = 0, rb = 0;
            for(int j = i - 1; j >= 0; j --) 
                if(height[j] > lb) lb = height[j];
            
            for(int j = i + 1; j < height.length; j ++) 
                if(height[j] > rb) rb = height[j];
            
            int waterHeld = Math.min(lb, rb) - height[i];
            if(waterHeld > 0) water += waterHeld;
        }
        return water;
    }
}