class Solution {
    public int numWaterBottles(int numBottles, int ne) {
        int ans = 0, fb = numBottles, eb = 0;
        while(fb > 0) {
            ans += fb;
            eb += fb;
            fb = eb / ne;
            eb = eb % ne;
        }
        return ans;
    }
}