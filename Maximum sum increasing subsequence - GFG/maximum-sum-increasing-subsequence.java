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
                    int Arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                        Arr[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.maxSumIS(Arr,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
	public int maxSumIS(int arr[], int n)  
	{  
	    int dp[] = new int[n];
	    return tab(arr, dp);
	}  
	
	public int tab(int[] nums, int[] dp) {
        int maxLen = 0;
        for(int i = 0; i < nums.length; i ++) {
            int ans = nums[i];
            for(int j = i - 1; j >= 0; j --) 
                if(nums[j] < nums[i]) 
                    ans = Math.max(ans, dp[j] + nums[i]);
            dp[i] = ans;
            maxLen = Math.max(maxLen, ans);
        }
        return maxLen;
    }
}