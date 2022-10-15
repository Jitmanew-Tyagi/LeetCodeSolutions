class Solution {
    public int minimizeArrayValue(int[] nums) {
        int s = 0, e = max(nums), ans = e;
        while(s <= e) {
            int mid = s + (e - s) / 2;
            if(check(nums, mid)) {
                ans = mid;
                e = mid - 1;
            }
            else s = mid + 1;
        }
        return ans;
    }
    
    
    public boolean check(int[] nums, int mid) {
        if(nums[0] > mid) return false;
        long pre = nums[0];
        for(int i = 1; i < nums.length; i ++) {
            long scope = mid - pre;
            if(nums[i] - scope > mid) return false;
            pre = nums[i] - scope;
        }
        return true;
    }
    
    public int max(int[] arr) {
        int ans = 0;
        for(int i : arr) ans = i > ans ? i : ans;
        return ans;
    }
}