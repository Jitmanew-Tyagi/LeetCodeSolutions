class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length, vis[] = new int[n];
        Arrays.fill(vis, -1);
        for(int i = 0; i < n; i ++) {
            if(vis[i] == -1) if(!isBip(graph, i, vis)) return false;
        }
        return true;
    }
    
    public boolean isBip(int[][] graph, int s, int[] vis) {
        int col = 0;
        Queue<Integer> que = new LinkedList<>();
        que.add(s);
        while(!que.isEmpty()) {
            int size = que.size();
            while(size --> 0) {
                int out = que.remove();
                if(vis[out] != -1 && vis[out] != col) return false;
                vis[out] = col;
                for(int nbr : graph[out]) {
                    if(vis[nbr] != -1 && vis[nbr] == col) return false;
                    if(vis[nbr] == -1) que.add(nbr);
                }
            }
            col = (col + 1) % 2;
        }
        return true;
    }
}