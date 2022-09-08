class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int[][] dirn = {{0, -1}, {-1, 0}, {1, 0}, {0, 1}};
        int n = matrix.length, m = matrix[0].length;
        int[][] indegree = new int[n][m];
        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < m; j ++) {
                for(int[] dir : dirn) {
                    int x = i + dir[0];
                    int y = j + dir[1];
                    if(x >= 0 && x < n && y >= 0 && y < m && matrix[i][j] < matrix[x][y]) {
                        indegree[x][y] ++;
                    }
                }
            }
        }
        
        Queue<Integer> que = new ArrayDeque<>();
        
        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < m; j ++) {
                if(indegree[i][j] == 0) que.add(i * m + j);
            }
        }
        int level = 0;
        while(!que.isEmpty()) {
            int size = que.size();
            while(size -- > 0) {
                int out = que.remove();
                int i = out / m, j = out % m;
                for(int[] dir : dirn) {
                    int x = i + dir[0];
                    int y = j + dir[1];
                    if(x >= 0 && x < n && y >= 0 && y < m && matrix[i][j] < matrix[x][y] && --indegree[x][y] == 0) {
                        que.add(x * m + y);
                    }
                }
            }
            level ++;
        }
        
        return level;
    }
}