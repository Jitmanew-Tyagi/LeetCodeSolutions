//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.countFriendsPairings(n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public long countFriendsPairings(int n) 
    {   long[] dp = new long[n + 1];
        long ans = helper(n, dp); 
        return ans;
    }
    
    public long helper(int N, long[] dp) {
        int MOD =  (int)(1e9) + 7;
        for(int n = 0; n <= N; n ++) {
            if(n == 0){
                dp[n] = 1;
                continue;
            }
            long ans = 0;
            ans = dp[n - 1] % MOD; //helper(n - 1, dp);
            if(n - 2 >= 0) ans += ((n - 1) * dp[n - 2] % MOD) % MOD; //(n - 1) * helper(n - 2, dp);
            dp[n] = ans % MOD;
        }
        return dp[N] % MOD;
    }
}    
 