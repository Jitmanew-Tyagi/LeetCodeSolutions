//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            int[] arr = new int[N];
            
            int K = Integer.parseInt(read.readLine());
            
            for(int i=0; i<N; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.numOfSubsets(arr,N,K));
        }
    }
}
// } Driver Code Ends

class Solution {
    static int numOfSubsets(int[] arr, int N, int K) {
        int[][] dp = new int[N + 1][K + 1];
        for(int[] d : dp) Arrays.fill(d, -1);
        return memo(arr, N, K, 0, 1, dp) - 1;
    }
    
    public static int memo(int[] arr, int N, int K, int i, int prod, int[][] dp) {
        if(prod > K) return 0;
        if(i == N) return dp[i][prod] = 1;
        if(dp[i][prod] != -1) return dp[i][prod];
        return dp[i][prod] = memo(arr, N, K, i + 1, prod, dp) + memo(arr, N, K, i + 1, prod * arr[i], dp);
    }
};