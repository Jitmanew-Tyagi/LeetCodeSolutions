class Solution {
    public int trap(int[] height) {
        int[] lb = getLeft(height), rb = getRight(height);
        int water = 0;
        for(int i = 0; i < height.length; i ++) {
            water += Math.max(0, Math.min(lb[i], rb[i]) - height[i]);
        }
        return water;
        
    }
    
    public static int[] getLeft(int[] arr) {
        int blb = 0, n = arr.length, ans[] = new int[n];
        for(int i = 0; i < n; i ++) {
            ans[i] = blb;
            blb = Math.max(blb, arr[i]);
        }
        return ans;
    }
    
    public static int[] getRight(int[] arr) {
        int blb = 0, n = arr.length, ans[] = new int[n];
        for(int i = n - 1; i >= 0; i --) {
            ans[i] = blb;
            blb = Math.max(blb, arr[i]);
        }
        return ans;
    }
}