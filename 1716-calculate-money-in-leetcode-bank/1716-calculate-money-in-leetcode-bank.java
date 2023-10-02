class Solution {
    public int totalMoney(int n) {
        int start = 1, ans = 0;
        while(n > 0) {
            for(int i = 0; i < 7 && n > 0; i ++) {
                ans += (start + i);
                n --;
            }
            start ++;
        }
        return ans;
    }
}