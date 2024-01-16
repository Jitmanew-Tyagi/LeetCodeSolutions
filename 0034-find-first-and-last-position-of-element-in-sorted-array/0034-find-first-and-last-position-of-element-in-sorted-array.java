class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[] {binarySearchMulti(nums, target, true), 
                         binarySearchMulti(nums, target, false)};
    }
    
    public int binarySearchMulti(int[] arr, int ele, boolean focc) {
        int s = 0, e = arr.length - 1;
        int ans = -1;
        while(s <= e) {
            int mid = (s + e) / 2; //better
            if(arr[mid] == ele)  {
                ans = mid;
                if(focc == true) e = mid - 1;
                else s = mid + 1;
            }
            else if(arr[mid] <  ele) s = mid + 1;
            else e = mid - 1;
        }

        return ans;
    }
}