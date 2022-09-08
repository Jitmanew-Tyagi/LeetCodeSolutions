class Solution {
    public int maxProfit(int[] p) {
        int profit = 0;
        for(int i = 1; i < p.length; i ++) {
            profit += p[i] - p[i - 1] > 0 ? p[i] - p[i - 1] : 0;
        }
        return profit;
    }
}