class Solution {
    public boolean equationsPossible(String[] equations) {
        par = new int[26];
        size = new int[26];
        for(int i = 0; i < 26; i ++) {
            par[i] = i;
            size[i] = 1;
        }
        
        for(String str : equations) {
            int u = str.charAt(0) - 'a', v = str.charAt(3) - 'a';
            if(str.charAt(1) == '!') continue;
            else if(findPar(u) != findPar(v)) union(findPar(u), findPar(v));
        }
        for(String str : equations){
            int u = str.charAt(0) - 'a', v = str.charAt(3) - 'a';
            if(str.charAt(1) == '!' && findPar(u) == findPar(v)) return false;
        }
        return true;
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