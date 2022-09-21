class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length, ans = 0;
        ArrayList<Integer>[] graph = getGraph(n, isConnected);
        boolean[] vis = new boolean[n];
        for(int i = 0; i < n; i ++) {
            if(vis[i] == false) {
                ans ++;
                consume(graph, i, vis);
            }
        }
        return ans;
    }
    
    public void consume(ArrayList<Integer>[] graph, int cs,boolean[] vis) {
        vis[cs] = true;
        for(int i : graph[cs]) if(!vis[i]) consume(graph, i, vis);
    }
    
    public ArrayList<Integer>[] getGraph(int n, int[][] cons) {
        ArrayList<Integer>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i ++) graph[i] = new ArrayList<Integer>();
        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < n; j ++) {
                if(cons[i][j] == 1) {
                    graph[i].add(j);
                    graph[j].add(i);
                }
            }
        }
        return graph;
    }
}