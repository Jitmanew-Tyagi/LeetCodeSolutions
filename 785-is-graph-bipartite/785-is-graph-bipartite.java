class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] visited = new int[graph.length];
        for(int i = 0; i < graph.length; i ++) {
            if(visited[i] == 0) if(!bfs(graph, i, visited)) return false;
        }
        return true;
    }
    
    public boolean bfs(int[][] graph, int src, int[] visited) {
        Queue<Integer> que = new LinkedList<>();
        que.add(src);
        int level = 1;
        while(!que.isEmpty()) {
            int size = que.size();
            while(size --> 0) {
                int rem = que.remove();
                if(visited[rem] != 0) {
                    if(visited[rem] % 2 != level % 2) return false; //continue;
                    // else return false;
                    continue;
                }
                visited[rem] = level;
                for(int nbr : graph[rem]) if(visited[nbr] == 0) que.add(nbr);
            }
            level ++;
        }
        return true;
    }
}