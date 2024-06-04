class Solution {
    public int mySqrt(int x) {
        int min = 0, max = x;
        int ans = 0;
        while(min <= max) {
            int mid = min + (max - min) / 2; //(min + max) / 2;
            long sq = mid;
            sq *= sq;
            if(sq <= x) {
                ans = mid; 
                min = mid + 1;
            }
            else max = mid - 1;
        }
        return ans;
    }
}