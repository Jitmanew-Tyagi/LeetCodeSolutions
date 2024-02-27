class Solution {
    public long maximumSumOfHeights(List<Integer> mh) {
        int a[]=new int[mh.size()];
        for(int i=0;i<mh.size();i++)a[i]=mh.get(i);
        long[] lbh = lbh(nsl(a), mh), rbh = rbh(nsr(a), mh);
        long ans = -1;
        for(int i = 0; i < a.length; i ++) {
            long tf = lbh[i] + rbh[i] - mh.get(i);
            ans = Math.max(ans, tf);
        }
        return ans;
    }
    
    public int[] nsl(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int n = arr.length, ans[] = new int[n];
        for(int i = 0; i < n; i ++) {
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]) st.pop();
            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return ans;
    }
    
    public int[] nsr(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int n = arr.length, ans[] = new int[n];
        for(int i = n - 1; i >= 0; i --) {
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]) st.pop();
            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return ans;
    }
    
    public long[] lbh(int[] nsl, List<Integer> mh) { //left building heights
        int n = nsl.length;
        long[] ans = new long[n]; 
        for(int i = 0; i < n; i ++) {
            int sl = nsl[i];
            if(sl == -1) {
                long tb = i + 1; // total buildings of current height
                long tf = tb * mh.get(i);
                ans[i] = tf;
            } else {
                long tb = i - sl;
                long tf = tb * mh.get(i) + ans[sl];
                ans[i] = tf;
            }
        }
        return ans;
    }
    
    public long[] rbh(int[] nsr, List<Integer> mh) { //right building heights
        int n = nsr.length;
        long[] ans = new long[n]; 
        for(int i = n - 1; i >= 0; i --) {
            int sr = nsr[i];
            if(sr == -1) {
                long tb = n - i; // total buildings of current height
                long tf = tb * mh.get(i);
                ans[i] = tf;
            } else {
                long tb = sr - i;
                long tf = tb * mh.get(i) + ans[sr];
                ans[i] = tf;
            }
        }
        return ans;
    }
}