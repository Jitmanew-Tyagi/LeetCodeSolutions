/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int s = 0, inf = peakIndexInMountainArray(mountainArr), e = mountainArr.length() - 1;
        int fh = incBS(target, mountainArr, s, inf), sh = decBS(target, mountainArr, inf, e);
        return fh != -1 ? fh : sh;
    }
    
    public int incBS(int target, MountainArray arr, int s, int e) {
        while(s <= e) {
            int mid = s + (e - s) / 2, midEle = arr.get(mid);
            if(midEle == target) return mid;
            if(midEle < target) s = mid + 1;
            else e = mid - 1;
        }
        return -1;
    }
    
    public int decBS(int target, MountainArray arr, int s, int e) {
        while(s <= e) {
            int mid = s + (e - s) / 2, midEle = arr.get(mid);
            if(midEle == target) return mid;
            if(midEle > target) s = mid + 1;
            else e = mid - 1;
        }
        return -1;
    }
    
    public int peakIndexInMountainArray(MountainArray arr) {
        int n = arr.length(), s = 0, e = n - 1, ans = -1;
        while(s <= e) {
            int mid = s + (e - s) / 2;
            if(arr.get(mid) > arr.get(mid + 1)) {
                ans = mid;
                e = mid - 1;
            } else s = mid + 1;
        }
        return ans;
    }
}