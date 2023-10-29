class Solution {
    public int orangesRotting(int[][] grid) {
        int nofo = 0, n = grid.length, m = grid[0].length, time = 0;
        Queue<Integer> que = new LinkedList<>();
        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < m; j ++) {
                if(grid[i][j] == 1) nofo ++;
                else if(grid[i][j] == 2) que.add(i * m + j);
            }
        }
        if(nofo == 0) return 0;
        int[][] dirns = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        while(!que.isEmpty()) {
            int size = que.size();
            while(size --> 0) {
                int out = que.remove();
                int i = out / m, j = out % m;
                for(int[] dir : dirns) {
                    int x = i + dir[0], y = j + dir[1];
                    if(x >= 0 && y >= 0 && x < n && y < m && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        nofo --;
                        if(nofo == 0) return time + 1;
                        que.add(x * m + y);
                    }
                }
            }
            time ++;
        }
        return nofo == 0 ? time : -1;
    }
}