//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] vis = new int[V];
        for(int i = 0; i < V; i ++){
            if(vis[i] == 0) if(DFS(i, adj, vis)) return true;
        }
        return false;
    }
    
    public boolean DFS(int s, ArrayList<ArrayList<Integer>> adj, int[] vis) {
        vis[s] = 1;
        for(int nbr : adj.get(s)) {
            if(vis[nbr] == 1) return true;
            if(vis[nbr] == 0) if(DFS(nbr, adj, vis)) return true;
        }
        vis[s] = 2;
        return false;
    }
}