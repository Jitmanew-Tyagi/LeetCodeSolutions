class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(graph, 0, ans, new ArrayList<Integer>(), new boolean[graph.length]);
        return ans;
    }
    
    public void helper(int[][] graph, int cs, List<List<Integer>> ans, List<Integer> curr, boolean[] vis) {
        if(cs == graph.length - 1) {
            curr.add(graph.length - 1);
            ans.add(new ArrayList<Integer>(curr));
            curr.remove(curr.size() - 1);
            return;
        }
        vis[cs] = true;
        curr.add(cs);
        for(int d : graph[cs]) {
            if(!vis[d]) helper(graph, d, ans, curr, vis);
        }
        curr.remove(curr.size() - 1);
        vis[cs] = false;
    }
}