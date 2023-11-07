//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int start = sc.nextInt();
            int end = sc.nextInt();

            Solution ob = new Solution();
            int ans = ob.minimumMultiplications(a, start, end);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {
        if(start == end) return 0;
        int mod = (int)1e5;
        boolean[] vis = new boolean[mod + 1];
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        vis[start] = true;
        int ans = 0;
        while(!que.isEmpty()) {
            int size = que.size();
            while(size --> 0) {
                int out = que.remove();
                for(int ele : arr) {
                    int res = (out * ele) % mod;
                    if(res == end) return ans + 1;
                    if(!vis[res]) {
                        vis[res] = true;
                        que.add(res);
                    }
                }
            }
            ans ++;
        }
        return -1;
    }
}
