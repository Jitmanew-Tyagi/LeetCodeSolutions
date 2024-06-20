class Solution {
    public int largestRectangleArea(int[] heights) {
        return getMaxRect(heights);
    }
    
    public int[] nsl(int[] arr) {
        int[] ans = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < arr.length; i ++) {
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]) st.pop();
            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return ans;
    }
    
    public int[] nsr(int[] arr) {
        int[] ans = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        for(int i = arr.length - 1; i >= 0; i --) {
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]) st.pop();
            ans[i] = st.isEmpty() ? arr.length : st.peek();
            st.push(i);
        }
        return ans;
    }
    
    public int getMaxRect(int[] arr) {
        int[] lb = nsl(arr);
        int[] rb = nsr(arr);
        
        int max = 0;
        for(int i = 0; i < arr.length; i ++) {
            int width = rb[i] - lb[i] - 1;
            int area = width * arr[i];
            if(area > max) max = area;
        }
        return max;
    }
}