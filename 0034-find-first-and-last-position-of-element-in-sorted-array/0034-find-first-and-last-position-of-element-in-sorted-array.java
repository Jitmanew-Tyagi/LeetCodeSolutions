class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[] {firstOcc(nums, target), lastOcc(nums, target)};
    }
    
     public int lastOcc(int[] arr, int  target) {
        int s = 0, e = arr.length - 1, ans = -1;
        while(s <= e) {
            int mid = (s + e) / 2;
            if(arr[mid] == target) {
                ans = mid;
                s = mid + 1;
            } else if(arr[mid] > target) e = mid - 1;
            else s = mid + 1;
        }
        return ans;
    }
    
     public static int firstOcc(int[] arr, int  target) {
        int s = 0, e = arr.length - 1, ans = -1;
        while(s <= e) {
            int mid = (s + e) / 2;
            if(arr[mid] == target) {
                ans = mid;
                e = mid - 1;
            } else if(arr[mid] > target) e = mid - 1;
            else s = mid + 1;
        }
        return ans;
    }
}