class Solution {
    public int largestRectangleArea(int[] heights) {
        return getMaxArea(getLeftBound(heights), getRightBound(heights), heights);
    }

    public int[] getLeftBound(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int n = heights.length, ans[] = new int[n];
        for(int i =  0; i < n; i ++) {
            int ele = heights[i];
            while(!st.isEmpty() && ele <= heights[st.peek()]) st.pop();
            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return ans;
    }

    public int[] getRightBound(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int n = heights.length, ans[] = new int[n];
        for(int i = n - 1; i >= 0; i --) {
            int ele = heights[i];
            while(!st.isEmpty() && ele <= heights[st.peek()]) st.pop();
            ans[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return ans;
    } 

    public int getMaxArea(int[] left, int[] right, int[] heights) {
        int maxArea = 0, n = heights.length;
        for(int i = 0; i < n; i ++) {
            int width = right[i] - left[i] - 1;
            int area = width * heights[i];
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }
}