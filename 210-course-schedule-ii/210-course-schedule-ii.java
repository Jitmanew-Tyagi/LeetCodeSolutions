class Solution {
    public int[] findOrder(int n, int[][] pre) {
        ArrayList<Integer>[] graph = new ArrayList[n];
        for(int i = 0;i < n; i ++) graph[i] = new ArrayList<>();
        int[] indeg = new int[n];
        for(int[] p : pre) {
            graph[p[1]].add(p[0]);
            indeg[p[0]] ++;
        }
        int idx = -1;
        int[] ans = new int[n];
        boolean[] visited = new boolean[n];
        Queue<Integer> que = new ArrayDeque<>();
        for(int i = 0; i < n; i ++) if(indeg[i] == 0) que.add(i);
        while(!que.isEmpty()) {
            int rem = que.remove();
            visited[rem] = true;
            ans[++ idx] = rem;
            for(int nbr : graph[rem]) 
                if(--indeg[nbr] == 0) que.add(nbr);
        }
        return idx < n - 1 ? new int[0] : ans;
    }
}