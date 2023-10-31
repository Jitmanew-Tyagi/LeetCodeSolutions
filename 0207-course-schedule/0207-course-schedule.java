class Solution {
    public boolean canFinish(int n, int[][] pre) {
        List<Integer>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i ++) graph[i] = new ArrayList<>();
        for(int[] a : pre) graph[a[0]].add(a[1]);
        Queue<Integer> que = new LinkedList<>();
        int idx = 0, ind[] = new int[n];
        for(int[] a : pre) ind[a[1]] ++;
        for(int i = 0; i < n; i ++) if(ind[i] == 0) que.add(i);
        while(!que.isEmpty()) {
            int out = que.remove();
            idx ++;
            for(int nbr : graph[out]) {
                ind[nbr] --;
                if(ind[nbr] == 0) que.add(nbr);
            }
        }
        return idx == n;
    }
}