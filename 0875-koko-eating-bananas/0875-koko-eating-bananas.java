class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int lo = 1, hi = (int)1e9; 
        
        while(lo < hi) {
            int mid = (lo + hi) / 2;
            if (getTime(piles, mid) <= h) hi = mid;
            else lo = mid+1 ;
        }
        return lo;
    }
    
    public static int getTime(int[] piles, int rate) {
        int sum = 0;
        for(int i : piles) 
            sum += (i-1)/rate+1;
        return sum;
    }
}