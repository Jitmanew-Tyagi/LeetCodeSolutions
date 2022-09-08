class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int i = 0; i < matrix.length; i ++) pq.add(new Pair(matrix[i][0], i, 0));
        while(k-->1) {
            Pair rem = pq.remove();
            if(rem.c + 1< matrix[rem.r].length) pq.add(new Pair(matrix[rem.r][rem.c + 1], rem.r, rem.c + 1));
        }
        return pq.remove().data;
    }
    
    class Pair implements Comparable<Pair>{
        int data, r, c;
        Pair(int data, int r, int c) {
            this.data = data;
            this.r = r;
            this.c = c;
        }
        @Override
        public int compareTo(Pair other){
            return this.data - other.data;
        }
    }
}