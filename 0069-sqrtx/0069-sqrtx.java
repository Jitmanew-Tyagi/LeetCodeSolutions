class Solution {
    public int mySqrt(int n) {
        if(n <= 1) return n;
        int s = 1, e = n, ans = 0;
        while(s <= e) {
            int mid = s + ((e - s) / 2); 
            if(mid <= n / mid) {
                ans = mid;
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return ans;
    }
}