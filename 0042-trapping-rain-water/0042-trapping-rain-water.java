class Solution {
    public int trap(int[] height) {
        int water = 0;
        int[] left = getLeft(height);
        int[] right = getRight(height);
        for(int i = 0; i < height.length; i ++) {
            int lb = left[i], rb = right[i];
            int waterHeld = Math.min(lb, rb) - height[i];
            if(waterHeld > 0) water += waterHeld;
        }
        return water;
    }
    
    public int[] getLeft(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        int blsf = 0;
        for(int i = 0; i < n; i ++) {
            ans[i] = blsf;
            if(arr[i] > blsf) blsf = arr[i];
        }
        return ans;
    }
    
    public int[] getRight(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        int brsf = 0;
        for(int i = n - 1; i >= 0; i --) {
            ans[i] = brsf;
            if(arr[i] > brsf) brsf = arr[i];
        }
        return ans;
    }
}