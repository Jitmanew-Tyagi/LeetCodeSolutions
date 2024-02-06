class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int s = 1, e = getMax(piles);
        int ans = -1;
        while(s <= e) {
            int mid = s + (e - s) / 2;
            if(completable(piles, mid, h)) {
                ans = mid;
                e = mid - 1;
            } else s = mid + 1;
        }
        return ans;
    }
    
    public boolean completable(int[] bananas, int speed, int allowedHrs) {
        int hours = 0;;
        for(int nob : bananas) {
            hours += Math.ceil(nob / (speed * 1.0));
        }
        return hours <= allowedHrs;
    }
    
    public int getMax(int[] arr) {
        int max = arr[0];
        for(int ele : arr) if(ele > max) max = ele;
        return max;
    }
}