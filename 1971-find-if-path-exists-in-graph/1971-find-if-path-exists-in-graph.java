class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<Integer>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i ++) graph[i] = new ArrayList<>();
        for(int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        
        return hasPath(graph, source, destination, new boolean[n]);
    }
    
    public boolean hasPath(ArrayList<Integer>[] graph, int s, int d, boolean[] vis) {
        if(s == d) return true;
        vis[s] = true;
        for(int i : graph[s]) if(!vis[i] && hasPath(graph, i, d, vis)) return true;
        return false;
    }
}