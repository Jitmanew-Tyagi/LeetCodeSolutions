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
// class Solution {
//     int minimumMultiplications(int[] arr, int start, int end) {
//         int ans = 0;
//         boolean[] vis = new boolean[10000]; 
//         Queue<Integer> que = new LinkedList<>();
//         que.add(start);
//         while(!que.isEmpty()) {
//             int size = que.size();
//             while(size --> 0) {
//                 int out = que.remove();
//                 vis[out] = true;
//                 for(int ele : arr) {
//                     int res = (out * ele) % 10000;
//                     if(res == end) return ans + 1;
//                     if(!vis[res]) que.add(res);
//                 }
//             }
//             ans ++;
//         }
//         return -1;
//     }
// }

class Solution {
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