class Solution {
    public int[] findOrder(int n, int[][] pre) {
        List<Integer>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i ++) graph[i] = new ArrayList<>();
        for(int[] a : pre) graph[a[0]].add(a[1]);
        int idx = 0, ans[] = new int[n], vis[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n; i ++) if(vis[i] == 0) if(!DFS(graph, i, vis, st)) return new int[0];
        while(!st.isEmpty()) ans[n - 1 - (idx ++)] = st.pop();
        return ans;
    }
    
    public boolean DFS(List<Integer>[] graph, int s, int[] vis, Stack<Integer> st) {
        vis[s] = 1;
        for(int nbr : graph[s]) {
            if(vis[nbr] == 1) return false;
            if(vis[nbr] == 0 && DFS(graph, nbr, vis, st) == false) return false;
        }
        st.push(s);
        vis[s] = 2;
        return true;
    }
}