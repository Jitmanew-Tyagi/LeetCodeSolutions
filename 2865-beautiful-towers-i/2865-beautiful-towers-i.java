class Solution {
    public long maximumSumOfHeights(List<Integer> mh) {
        int[] nsl = nsl(mh), nsr = nsr(mh);
        long[] ls = leftSum(mh, nsl), rs = rightSum(mh, nsr);
        long ans = 0;
        for(int i = 0; i < mh.size(); i ++) {
            ans = Math.max(ans, ls[i] + rs[i] - mh.get(i));
        }
        return ans;
    }
    
    public int[] nsl(List<Integer> arr) {
        int n = arr.size(), ans[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n; i ++) {
            while(!st.isEmpty() && arr.get(st.peek()) >= arr.get(i)) st.pop();
            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return ans;
    }
    
    public int[] nsr(List<Integer> arr) {
        int n = arr.size(), ans[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = n - 1; i >= 0; i --) {
            while(!st.isEmpty() && arr.get(st.peek()) >= arr.get(i)) st.pop();
            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return ans;
    }
    
    public long[] leftSum(List<Integer> arr, int[] nsl) {
        int n = nsl.length;
        long ans[] = new long[n];
        for(int i = 0; i < n; i ++) 
            ans[i] = nsl[i] == -1 ? (long)arr.get(i) * (i + 1) : (long)(i - nsl[i]) * arr.get(i) + ans[nsl[i]];
        return ans;
    }
    
    public long[] rightSum(List<Integer> arr, int[] nsr) {
        int n = nsr.length;
        long ans[] = new long[n];
        for(int i = n - 1; i >= 0; i --) {
            ans[i] = nsr[i] == -1 ? (long)arr.get(i) * (n - i) : (long)(nsr[i] - i) * arr.get(i) + ans[nsr[i]];
        }
        return ans;
    }
}