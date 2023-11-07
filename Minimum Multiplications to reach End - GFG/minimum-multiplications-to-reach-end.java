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

class Solution {
    int int_max = (int)1e9;
    int minimumMultiplications(int[] arr, int start, int end) {
        if(start==end) return 0;
        Queue<int[]> q = new LinkedList<>();
        int mod = (int)1e5;
        boolean[] visited= new boolean[mod+1];
        visited[start] = true;
        q.add(new int[]{0,start});
        
        while(!q.isEmpty()){
            int[] front  = q.poll();
            int step = front[0], curr = front[1];
            for(int adj: arr){
                int mul  = (adj*curr)%mod;
                if(!visited[mul]){
                    visited[mul] = true;
                    if(mul==end) return step+1;
                    q.add(new int[]{step+1,mul});
                }
            }
        }
        return -1;
    }
}