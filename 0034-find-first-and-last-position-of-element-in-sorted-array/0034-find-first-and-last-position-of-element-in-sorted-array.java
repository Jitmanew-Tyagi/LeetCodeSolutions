class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[] {firstOcc(nums, target), lastOcc(nums, target)};
    }
    
    public int firstOcc(int[] arr, int x) {
        int s = 0, e = arr.length - 1, ans = -1;
        while(s <= e) {
            int mid = s + (e - s) / 2; // (s + e) / 2
            if(arr[mid] == x) {
                ans = mid;
                e = mid - 1;
            } else if(arr[mid] < x) s = mid + 1;
            else e = mid - 1;
        }
        return ans;
    }
    
    public int lastOcc(int[] arr, int x) {
        int s = 0, e = arr.length - 1, ans = -1;
        while(s <= e) {
            int mid = s + (e - s) / 2; // (s + e) / 2
            if(arr[mid] == x) {
                ans = mid;
                s = mid + 1;
            } else if(arr[mid] < x) s = mid + 1;
            else e = mid - 1;
        }
        return ans;
    }
}