class Solution {
    public int swimInWater(int[][] grid) {
        int time = 0, n = grid.length, m = grid[0].length, dirns[][] = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        boolean[][] vis = new boolean[n][m];
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> {
            int x1 = a / m, x2 = b / m, y1 = a % m, y2 = b % m;
            return grid[x1][y1] - grid[x2][y2];
        });
        pq.add(0);
        vis[0][0] = true;
        int minHeight = 0;
        while(!pq.isEmpty()) {
            int rem = pq.remove();
            int x = rem / m, y = rem % m;
            time += Math.max(0, grid[x][y] - minHeight);
            if(x == n - 1 && y == m - 1) break;
            minHeight = Math.max(grid[x][y], minHeight);
            for(int[] dir : dirns) {
                int r = x + dir[0], c = y + dir[1];    
                if(r >= 0 && r < n && c >= 0 && c < m && !vis[r][c]) {
                    vis[r][c] = true;
                    pq.add(r * m + c);
                }
            }
        }
        return time;
    }
}