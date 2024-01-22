class Solution {
    public int largestRectangleArea(int[] heights) {
        return getMaxArea(heights);
    }
    
    public static int[] leftBoundaries(int[] arr) {
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
    
    public static int[] rightBoundaries(int[] arr) {
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
    
    public int getMaxArea(int[] arr) {
        int maxArea = 0;
        int[] left = leftBoundaries(arr);
        int[] right = rightBoundaries(arr);
        for(int i = 0; i < arr.length; i ++) {
            int width = right[i] - left[i] - 1;
            int height = arr[i];
            int area = width * height;
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}