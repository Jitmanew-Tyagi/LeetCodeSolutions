class Solution {
    public int reverse(int x) {
        boolean isNeg = x < 0;
        // int n = x > 0 ? x : -x;
        int n = 0;
        n = reverseHelper(x);
        
        return n;
    }
    
    public int reverseHelper(int n) {
        long ans = 0;
        while(n != 0) {
            ans = (ans * 10) + (n % 10);
            n /= 10;
        }
        
        return (ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE) ? 0 : (int) ans;
    }
}