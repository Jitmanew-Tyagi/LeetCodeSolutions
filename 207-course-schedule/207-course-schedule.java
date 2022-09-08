class Solution {
    public boolean canFinish(int n, int[][] pre) {
        ArrayList<Integer>[] graph = new ArrayList[n];
        for(int i = 0;i < n; i ++) graph[i] = new ArrayList<>();
        int[] state = new int[n];
        for(int[] p : pre) {
            graph[p[1]].add(p[0]);
        }
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < n; i ++){
            if(state[i] == 0) dfs(graph, i, state, ans);
        }
        return ans.size() == n;
    }
    public boolean dfs(ArrayList<Integer>[] graph, int src, int[] state, List<Integer> ans) {
        state[src] = 1;
        for(int nbr : graph[src]){
            if(state[nbr] == 1) return false;
            if(state[nbr] == 0) if(!dfs(graph, nbr, state, ans)) return false;
        }
        state[src] = 2;
        ans.add(src);
        return true;
    }
}