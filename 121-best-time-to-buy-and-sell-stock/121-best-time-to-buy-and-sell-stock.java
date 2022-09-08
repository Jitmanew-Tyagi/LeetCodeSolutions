class Solution {
    public int maxProfit(int[] prices) {
        int min = (int) 1e9, maxProfit = 0;
        for(int i : prices) {
            min = Math.min(i, min);
            maxProfit = Math.max(maxProfit, i - min);
        }
        return maxProfit;
    }
}