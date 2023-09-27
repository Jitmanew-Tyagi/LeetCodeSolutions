class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        for(int[] d : dp) Arrays.fill(d, -1);
        int ans = rec(coins.length, coins, 0, amount, dp);
        return ans == Integer.MAX_VALUE - 1 ? -1 : ans;
    }
    
    public static int rec(int n, int[] coins, int i, int amount, int[][] dp) {
        if(amount == 0) return dp[i][amount] = 0;
        if(i == n || amount < 0) return Integer.MAX_VALUE - 1;
        if(dp[i][amount] != -1) return dp[i][amount];
        int a1 = rec(n, coins, i + 1, amount, dp);
        int a2 = 1 + rec(n, coins, i, amount - coins[i], dp);
        return dp[i][amount] = Math.min(a1, a2);
    }
}