class Solution {
    public int largestRectangleArea(int[] heights) {
        return getMaxArea(heights);
    }
    
    public int[] nsl(int[] arr) {
        int n = arr.length, ans[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n; i ++) {
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]) st.pop();
            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return ans;
    }
    
    public int[] nsr(int[] arr) {
        int n = arr.length, ans[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = n - 1; i >= 0; i --) {
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]) st.pop();
            ans[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return ans;
    }
    
    public int getMaxArea(int[] bars) {
        int[] lb = nsl(bars);
        int[] rb = nsr(bars);
        int max = -1;
        for(int i = 0; i < bars.length; i ++) {
            int bh = bars[i];
            int bw = rb[i] - lb[i] - 1;
            int area = bh * bw;
            max = Math.max(area, max);
        }
        return max;
    }
}