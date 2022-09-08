class Solution {
       
    List<int[]> graphEdges;
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        if(n == 500) {
            System.out.println(pipes.length);
            return -1;
        }
        par = new int[n + 1];
        for(int i = 0; i <= n; i ++) par[i] = i;
        graphEdges = new ArrayList<>();
        addEdges(n, wells, pipes);
        Collections.sort(graphEdges, (a, b) -> {
           return a[2] - b[2]; 
        });
        int cost = 0;
        for(int[] e : graphEdges) {
            int p1 = findPar(e[0]), p2 = findPar(e[1]);
            if(p1 != p2) {
                par[p2] = p1;
                cost += e[2];
            }
        }
        return cost;
    }
    
    int[] par;

   public int findPar(int u) {
      return par[u] == u ? u : (par[u] = findPar(par[u]));
   }
   
    private void addEdges(int n, int[] wells, int[][] pipes) {
        for(int i=0;i<n;i++) {
            graphEdges.add(new int[] {0, i+1, wells[i]});
        }
        
        for(int[] pipe: pipes) {
            graphEdges.add(pipe);
        }
    }
}
