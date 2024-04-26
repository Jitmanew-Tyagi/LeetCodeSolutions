class Solution {
    public int reverse(int n) {
        long ans = 0;
        while(n != 0) {
            ans = (ans * 10) + (n % 10);
            n /= 10;
        }
        return (ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE) ? 0 : (int) ans;
    }
    
    
}