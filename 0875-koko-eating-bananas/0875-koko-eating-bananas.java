class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int s = 1, e = maxOfArray(piles);
        int ans = -1;
        while(s <= e) {
            int mid = s + (e - s) / 2;
            if(isPossible(piles, mid, h)){
                ans = mid;
                e = mid - 1;
            } else s = mid + 1;
        }
        return ans;
    }
    
    public boolean isPossible(int[] piles, int speed, int totalHours) {
        int hours = 0;
        for(int b : piles) {
            hours += Math.ceil(b / (speed * 1.0));
        }
        return hours <= totalHours;
    }
    
    
    public int maxOfArray(int[] arr) {
        int max = arr[0];
        for(int ele : arr) if(ele > max) max = ele;
        return max;
    }
}