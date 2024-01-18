class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = binarySearch(nums, target, true);
        int last = binarySearch(nums, target, false);
        return new int[] {first, last};
    }
    
    public int binarySearch(int[] arr, int x, boolean firstOcc) {
        int s = 0, e = arr.length - 1, ans = -1;
        while(s <= e) {
            int mid = s + (e - s) / 2;
            if(arr[mid] == x) {
                ans = mid;
                if(firstOcc) e = mid - 1;
                else s = mid + 1;
            } else if(arr[mid] < x) s = mid + 1;
            else e = mid - 1;
        }
        return ans;
    }
}