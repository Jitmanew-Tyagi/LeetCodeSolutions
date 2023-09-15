class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min = 1, max = max(piles);
        int ans = -1;
        while(min <= max) {
            int mid = min + (max - min) / 2;
            if(allBananasConsumed(piles, mid, h)) {
                ans = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return ans;
    }
    
    public boolean allBananasConsumed(int[] piles, int speed, int h) {
        int currHrs = 0;
        for(int b : piles) {
            currHrs += Math.ceil(b / (speed * 1.0));
        }
        return currHrs <= h;   
    }
    
    public int max(int[] arr) {
        int ans = arr[0];
        for(int ele : arr) ans = Math.max(ele, ans);
        return ans;
    }
}