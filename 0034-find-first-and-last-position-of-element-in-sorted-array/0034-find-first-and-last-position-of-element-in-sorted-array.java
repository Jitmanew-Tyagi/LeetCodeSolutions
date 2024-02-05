class Solution {
    public int[] searchRange(int[] nums, int target) {
        int focc = binarySearch(nums, target, true);
        int locc = binarySearch(nums, target, false);
        return new int[] {focc, locc};
    }
    
    public int binarySearch(int[] arr, int target, boolean focc) {
        int s = 0, e = arr.length - 1;
        int ans = -1;
        while(s <= e) {
            int mid = s + (e - s) / 2;
            if(arr[mid] == target) {
                ans = mid;
                if(focc) e = mid - 1;
                else s = mid + 1;
            } else if(arr[mid] < target) s = mid + 1;
            else e = mid - 1;
        }
        return ans;
    }
}