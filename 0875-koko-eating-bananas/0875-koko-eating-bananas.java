class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min = 1, max = maxOfArray(piles);
        int ans = -1;
        while(min <= max) {
            int mid = min + (max - min) / 2;
            if(isPossible(piles, mid, h)) {
                ans = mid;
                max = mid - 1;
            } else min = mid + 1;
        }
        return ans;
    }
    
    public boolean isPossible(int[] piles, int speed, int hours) {
        int time = 0;
        for(int pile : piles) {
            time += Math.ceil(pile / (speed * 1.0));
        }
        return time <= hours;
    }
    
    public int maxOfArray(int[] arr) {
        int max = arr[0];
        for(int ele : arr) if(ele > max) max = ele;
        return max;
    }
}