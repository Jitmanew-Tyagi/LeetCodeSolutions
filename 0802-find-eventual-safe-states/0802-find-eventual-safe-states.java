class Solution {
    public List<Integer> eventualSafeNodes(int[][] g) {
        int n = g.length, vis[] = new int[n], ind[] = new int[n];
        List<Integer> graph[] = new ArrayList[n], ans = new ArrayList<>();
        for(int i = 0; i < n; i ++) graph[i] = new ArrayList<>();
        for(int i = 0; i < n; i ++) {
            for(int ele : g[i]) {
                graph[ele].add(i);
                ind[i] ++;
            }
        }
        Queue<Integer> que = new LinkedList<>();
        for(int i = 0; i < n; i ++) if(ind[i] == 0) que.add(i);
        while(!que.isEmpty()) {
            int out = que.remove();
            ans.add(out);
            for(int nbr : graph[out]) {
                if(-- ind[nbr] == 0) que.add(nbr);
            }
        }
        Collections.sort(ans);
        return ans;
    }
}