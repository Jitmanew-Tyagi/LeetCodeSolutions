class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int i = 0; i < mat.length; i ++) {
            int power = getPower(mat[i]);
            Pair pairKaObj = new Pair(power, i);
            pq.add(pairKaObj);
            if(pq.size() > k) {
                pq.remove();
            }
        }
        
        int ans[] = new int[k], idx = k - 1;
        while(!pq.isEmpty()) {
            Pair obj = pq.remove();
            ans[idx] = obj.rowNo;
            idx --;
        }
        return ans;
    }
    
    class Pair implements Comparable<Pair>{
        int power;
        int rowNo;
        
        public Pair(int power, int rowNo) {
            this.power = power;
            this.rowNo = rowNo;
        }   
        
        @Override
        public int compareTo(Pair other) { //asc -> this - other else other - this
            if(this.power == other.power) 
                return other.rowNo - this.rowNo;
            return other.power - this.power; 
            
        }
    }
    
    public int getPower(int[] arr) {
        int s = 0, e = arr.length - 1, ans = -1;
        while(s <= e) {
            int mid = s + (e - s) / 2;
            if(arr[mid] == 1) {
                ans = mid;
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return ans + 1;
    }
}