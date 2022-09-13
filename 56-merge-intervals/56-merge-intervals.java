class Solution {
    public int[][] merge(int[][] intervals) {
        Dt[] ans = new Dt[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            ans[i] = new Dt(intervals[i][0], intervals[i][1]);
        }
        Arrays.sort(ans);
        Stack<Dt> st = new Stack<>();
        for (int i = 0; i < intervals.length; i++) {
            Dt temp = new Dt(ans[i].f, ans[i].s);
            if (st.isEmpty()) st.push(temp);
            else {
                if (temp.f > st.peek().s) st.push(temp);
                else {
                    Dt t = st.pop();
                    st.push(new Dt(t.f, Math.max(t.s, temp.s)));
                }
            }
            
        }
        int[][] ans_ = new int[st.size()][2];
        int i = st.size() - 1;
        while(!st.isEmpty()) {
            Dt x = st.pop();
            int[] x_ = {x.f, x.s};
            ans_[i --] = x_;
        }
        
        return ans_;
    }
   
    public static class Dt implements Comparable<Dt> {
        int f, s;
        Dt(int f, int s) {
            this.f = f;
            this.s = s;
        }

        public int compareTo (Dt other) {
            if (this.f != other.f) return (this.f - other.f);
            return (this.s - other.s);
        } 
    } 
}