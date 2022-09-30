class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] != 0) return -1;
        int[][] dirn = {{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}};
        int n = grid.length, m = grid[0].length, steps = 0;
        Queue<Integer> que = new LinkedList<>();
        que.add(0);
        grid[0][0] = -1;
        while(!que.isEmpty()) {
            int size = que.size();
            steps ++;
            while(size --> 0) {
                int cord = que.remove();
                int x = cord / m, y = cord % m;
                if(x == n - 1 && y == m - 1) return steps;
                for(int[] dir : dirn) {
                    int nx = x + dir[0], ny = y + dir[1];
                    if(nx >= 0 && ny >= 0 && nx < n && ny < m && grid[nx][ny] == 0) {
                        grid[nx][ny] = -1;
                        que.add(nx * m + ny);
                    }
                }
            }
        }
        return -1;
    }
}