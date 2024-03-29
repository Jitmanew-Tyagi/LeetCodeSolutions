//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            String st[] = read.readLine().trim().split("\\s+");
            int edg = Integer.parseInt(st[0]);
            int nov = Integer.parseInt(st[1]);

            for (int i = 0; i < nov; i++)
                list.add(i, new ArrayList<Integer>());

            int p = 0;
            for (int i = 1; i <= edg; i++) {
                String s[] = read.readLine().trim().split("\\s+");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                list.get(u).add(v);
            }

            int[] res = new Solution().topoSort(nov, list);

            if (check(list, nov, res) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
    static boolean check(ArrayList<ArrayList<Integer>> list, int V, int[] res) {
        
        if(V!=res.length)
        return false;
        
        int[] map = new int[V];
        for (int i = 0; i < V; i++) {
            map[res[i]] = i;
        }
        for (int i = 0; i < V; i++) {
            for (int v : list.get(i)) {
                if (map[i] > map[v]) return false;
            }
        }
        return true;
    }
}

// } Driver Code Ends


/*Complete the function below*/


class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // boolean vis[] = new boolean[V];
        // int ans[] = new int[V], idx = 0;
        // Stack<Integer> st = new Stack<>();
        // for(int i = 0; i < V; i ++) 
        //     if(!vis[i]) DFS(i, adj, st, vis);
        // while(!st.isEmpty()) ans[idx ++] = st.pop();
        // return ans;
        return BFS(V, adj);
    }
    
    public static void DFS(int s, ArrayList<ArrayList<Integer>> adj, Stack<Integer> st, boolean[] vis) {
        vis[s] = true;
        for(int nbr : adj.get(s)) if(!vis[nbr]) DFS(nbr, adj, st, vis);
        st.push(s);
    }
    
    public static int[] BFS(int n, ArrayList<ArrayList<Integer>> adj) {
        int ans[] = new int[n], idx = 0, ind[] = new int[n];
        for(int i = 0; i < n; i ++) {
            for(int ele : adj.get(i)) ind[ele] ++;
        }
        
        Queue<Integer> que = new LinkedList<>();
        for(int i = 0; i < n; i ++) if(ind[i] == 0) que.add(i);
        while(!que.isEmpty()) {
            int out = que.remove();
            ans[idx ++] = out;
            for(int nbr : adj.get(out)) {
                ind[nbr] --;
                if(ind[nbr] == 0) que.add(nbr);
            }
        }
        return ans;
    }
}
