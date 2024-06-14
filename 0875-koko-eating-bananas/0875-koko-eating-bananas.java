class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int ans = -1, s = 1, e = max(piles);
        while(s <= e) {
            int mid = s + (e - s) / 2; // (s + e) / 2;
            if(isPossible(piles, mid, h)) {
                ans = mid;
                e = mid - 1;
            } else s = mid + 1;
        }
        return ans;
    }
    
    public boolean isPossible(int[] arr, int speed, int totalTime) {
        int h = 0;
        for(int b : arr) {
            h += Math.ceil((b * 1.0) / speed);
        }
        return h <= totalTime;
    }
    
    public int max(int[] arr) {
        int max = arr[0];
        for(int ele : arr) if(ele > max) max = ele;
        return max;
    }
}