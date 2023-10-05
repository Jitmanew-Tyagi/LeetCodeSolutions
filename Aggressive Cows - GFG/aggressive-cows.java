//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int n;
            n = sc.nextInt();

            int k;
            k = sc.nextInt();

            int[] v = new int[n];
            for (int i = 0; i < n; i++) v[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.solve(n, k, v);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public static int solve(int n, int k, int[] stalls) {
        Arrays.sort(stalls);
        int min = 1, max = (int)1e9, ans = 0;
        while(min <= max) {
            int mid = min + (max - min) / 2;
            if(completable(stalls, mid, k)) {
                ans = mid;
                min = mid + 1;
            } else max = mid - 1;
        }
        return ans;
    }
    
    public static boolean completable(int[] stalls, int dist, int k) {
        int prev = stalls[0], noc = 1;
        for(int i = 1; i < stalls.length; i ++) {
            if(stalls[i] - prev >= dist) {
                noc ++;
                prev = stalls[i];
            }
        }
        return noc >= k;
    }
}