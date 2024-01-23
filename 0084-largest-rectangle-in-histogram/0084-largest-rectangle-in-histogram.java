class Solution {
    public int largestRectangleArea(int[] heights) {
        return maxArea(heights);
    }
    
    public int[] leftBound(int[] arr) {
        int n = arr.length, ans[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n; i ++) {
            int ele = arr[i];
            while(!st.isEmpty() && arr[st.peek()] >= ele) st.pop();
            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return ans;
    }
    
    public int[] rightBound(int[] arr) {
        int n = arr.length, ans[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = n - 1; i >= 0; i --) {
            int ele = arr[i];
            while(!st.isEmpty() && arr[st.peek()] >= ele) st.pop();
            ans[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return ans;
    }
    
    public int maxArea(int[] arr) {
        int[] left = leftBound(arr);
        int[] right = rightBound(arr);
        int n = arr.length, maxArea = 0;
        for(int i = 0; i < n; i ++) {
            int width = right[i] - left[i] - 1;
            int height = arr[i];
            int area = height * width;
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}