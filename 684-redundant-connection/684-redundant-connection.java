class Solution {
    public int[] findRedundantConnection(int[][] con) {
        int n = con.length;
        par = new int[n + 1];
        size = new int[n + 1];
        for(int i = 0; i <= n;  i++) par[i] = i;
        for(int i = 0; i <= n;  i ++) size[i] = 1;
        int norc = 0, noc = 0;
        for(int[] edge : con) {
            int u = edge[0], v = edge[1];
            int p1 = findPar(u), p2 = findPar(v);
            if(p1 != p2) union(p1, p2);
            else return new int[]{u, v};
        }
        return new int[0];
        
    }
    int[] par, size;
    
    public int findPar(int v) {
        return par[v] == v ? v : (par[v] = findPar(par[v]));
    }
    
    public void union(int u, int v) {
        if(size[u] >= size[v]) {
            par[v] = u;
            size[u] += size[v];
        } else{
            par[u] = v;
            size[v] += size[u];
        }
    }
}