class Solution {
    public int[] searchRange(int[] nums, int target) {
        int focc = firstOccurance(nums, target);
        int locc = lastOccurance(nums, target);
        return new int[] {focc, locc};
    }
    
    public int firstOccurance(int[] arr, int target) {
        int s = 0, e = arr.length - 1;
        int ans = -1;
        while(s <= e) {
            int mid = s + (e - s) / 2;
            if(arr[mid] == target) {
                ans = mid;
                e = mid - 1;
            } else if(arr[mid] < target) s = mid + 1;
            else e = mid - 1;
        }
        return ans;
    }
    
    public int lastOccurance(int[] arr, int target) {
        int s = 0, e = arr.length - 1;
        int ans = -1;
        while(s <= e) {
            int mid = s + (e - s) / 2;
            if(arr[mid] == target) {
                ans = mid;
                s = mid + 1;
            } else if(arr[mid] < target) s = mid + 1;
            else e = mid - 1;
        }
        return ans;
    }
}