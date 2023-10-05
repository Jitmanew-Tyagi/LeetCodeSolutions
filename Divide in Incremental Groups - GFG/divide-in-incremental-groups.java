//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            int N = Integer.parseInt(br.readLine().trim());
            int K = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            System.out.println(ob.countWaystoDivide(N, K));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int countWaystoDivide(int N, int K) {
        int[][][] dp = new int[N + 1][K + 1][N + 1];
        for(int i = 0; i <= N; i ++) {
            for(int j = 0; j <= K; j ++) {
                for(int k = 0; k <= N; k ++) {
                    dp[i][j][k] = -1;
                }
            }
        } 
        return helper(N, K, 1, dp);
    }
    
    public int helper(int n, int k, int prev, int[][][] dp) {
        if(n < prev || n < k) return 0;
        if(n >= prev && k == 1) return dp[n][k][prev] = 1;
        if(dp[n][k][prev] != -1) return dp[n][k][prev];
        int ans = 0;
        for(int i = prev; i < n; i ++) {
            ans += helper(n - i, k - 1, i, dp);
        }
        return dp[n][k][prev] = ans;
    }
}