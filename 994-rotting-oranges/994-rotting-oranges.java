class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        Queue<Integer> que = new LinkedList<>();
        int nofo = 0;
        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < m; j ++) {
                if(grid[i][j] == 1) nofo ++;
                if(grid[i][j] == 2){
                    int idx = i * m + j;
                    que.add(idx);
                }
            }
        }
        if(nofo == 0) return 0;
        int level = 0;
        int[][] dirn = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        while(!que.isEmpty()) {
            int size = que.size();
            while(size --> 0) {
                int out = que.remove();
                int a = out / m, b = out % m;
                for(int[] dir : dirn) {
                    int x = a + dir[0];
                    int y = b + dir[1];
                    if(x < 0 || y < 0 || x >= n || y >= m || grid[x][y] != 1) continue;
                    grid[x][y] = 2;
                    que.add(x * m + y);
                    nofo --;
                    if(nofo == 0) return level + 1;
                }
            }
            level ++;
        }
        return nofo == 0 ? level : -1;
    }
}