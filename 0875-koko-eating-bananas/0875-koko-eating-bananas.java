class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min = 1, max = maxOfArray(piles);
        int ans = -1;
        while(min <= max) {
            int mid = min + (max - min) / 2;
            if(isPossible(piles, mid, h)) {
                ans = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return ans;
    }
    
    public int maxOfArray(int[] arr) {
        int max = arr[0];
        for(int ele : arr) max = Math.max(ele, max);
        return max;
    }
    
    public boolean isPossible(int[] arr, int speed, int totalHours) {
        int hours = 0;
        for(int nob : arr) {
            hours += Math.ceil(nob / (speed * 1.0));
            if(hours > totalHours) return false; 
        }
        return hours <= totalHours;
    }
}