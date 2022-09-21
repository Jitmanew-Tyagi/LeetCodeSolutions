class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size(), possible = 0;
        boolean[] vis = new boolean[n];
        for(int i = 0; i < n; i ++) {
            if(!vis[i]) {
                if(++ possible > 1) return false;
                consume(rooms, i, vis);
            }
        }
        return true;
    }
    
    public void consume(List<List<Integer>> graph, int cs, boolean[] vis) {
        vis[cs] = true;
        for(int i : graph.get(cs)) if(!vis[i]) consume(graph, i, vis);
    }
}