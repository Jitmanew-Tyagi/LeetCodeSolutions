class Solution {
    public int shortestDistance(int[][] maze, int[] start, int[] dest) {
        int n = maze.length, m = maze[0].length;
        int sr = start[0], sc = start[1], er = dest[0], ec = dest[1];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(sr, sc, 0));
        int[][] distance = new int[n][m];
        for(int[] d : distance) Arrays.fill(d, 1000000);
        distance[sr][sc] = 0;
        int[][] dirn = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        while(!pq.isEmpty()) {
            Pair out = pq.remove();
            for(int[] dir : dirn) {
            int r = out.r, c = out.c, steps = out.steps;
                while(r >= 0 && c >= 0 && r < n && c < m && maze[r][c] == 0) {
                    r += dir[0];
                    c += dir[1];
                    steps ++;
                }
                r -= dir[0];
                c -= dir[1];
                steps --;
                
                if(steps >= distance[r][c]) continue;
                if(r == er && c == ec) return steps;
                distance[r][c] = steps;
                pq.add(new Pair(r, c, steps));
            }
        }
        return -1;
    }
    
    class Pair implements Comparable<Pair>{
        int r, c, steps;
        Pair(int r, int c, int steps) {
            this.r = r;
            this.c = c;
            this.steps = steps;
        }
        
        public int compareTo(Pair other) {
            return this.steps - other.steps;
        }
    }
}