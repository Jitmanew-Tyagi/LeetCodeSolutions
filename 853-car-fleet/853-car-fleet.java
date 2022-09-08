class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        Pair[] arr = new Pair[n];
        for(int i = 0; i < n; i ++) 
            arr[i] = new Pair(position[i], speed[i]);
        Arrays.sort(arr);
        Stack<Pair> st = new Stack<>();
        st.push(arr[n - 1]);
        int idx = n - 2;
        while(idx >= 0) {
            Pair inc = arr[idx], alr = st.peek();
            double sp1 = (target - inc.pos * 1.0) / inc.sp, sp2 = (target - alr.pos * 1.0) / alr.sp;
            // System.out.println(inc.sp + " " + inc.pos + " " + sp1 + " " + sp2);
            if(sp1 > sp2) st.push(inc);
            idx --;
        }
        return st.size();
    }
    class Pair implements Comparable<Pair>{
        int pos, sp;
        Pair(int pos, int sp) {
            this.pos = pos;
            this.sp = sp;
        }
        public int compareTo(Pair other) {
            return this.pos - other.pos;
        }
    }
}