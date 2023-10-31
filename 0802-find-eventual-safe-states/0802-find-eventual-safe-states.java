class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int[] vis = new int[graph.length];
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < graph.length; i ++) {
            if(vis[i] == 0) DFS(i, graph, vis);
        }
        for(int i = 0; i < graph.length; i ++) if(vis[i] == 2) ans.add(i);
        return ans;
    }
    
    public boolean DFS(int s, int[][] graph, int[] vis) {
        vis[s] = 1;
        for(int nbr : graph[s]) {
            if(vis[nbr] == 1) return true;
            if(vis[nbr] == 0) if(DFS(nbr, graph, vis)) return true;
        }
        vis[s] = 2;
        return false;
    }
}