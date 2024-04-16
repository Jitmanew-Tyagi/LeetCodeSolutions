class Solution {
    public int reverse(int x) {
        long temp = x;
        long ans = 0;
        boolean isNeg = temp < 0;
        if(temp < 0) temp *= -1; 
        while(temp > 0) {
            ans = ans * 10 + (temp % 10);
            temp /= 10;
        }
        if(isNeg) ans *= -1;
        if(ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE) return 0;
        return (int)ans;
    }
}