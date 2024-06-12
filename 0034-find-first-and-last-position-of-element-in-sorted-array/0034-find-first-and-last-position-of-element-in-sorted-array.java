class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[] {getOcc(nums, target, true), getOcc(nums, target, false)};
    }
    
    
    public static int getOcc(int[] arr, int x, boolean focc) {
        int s = 0, e = arr.length - 1, ans = -1;
        while(s <= e) {
            int mid = s + (e - s) / 2; // (s + e) / 2
            if(arr[mid] == x) {
                ans = mid;
                if(focc) e = mid - 1;
                else s = mid + 1;
            } else if(arr[mid] < x) s = mid + 1;
            else e = mid - 1;
        }
        return ans;
    }
    
}


