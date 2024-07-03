class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length, ans[] = new int[n - k + 1];
        int[] ngr = ngr(nums);
        int i = 0, j = 0;
        while(i < ans.length) {
            if(j < i) j = i;
            while(ngr[j] < n && ngr[j] < i + k) j = ngr[j];
            ans[i ++] = nums[j];
        }
        return ans;
    }
    
    public int[] ngr(int[] arr) {
        int n = arr.length, ans[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = n - 1; i >= 0; i --) {
            while(!st.isEmpty() && arr[st.peek()] <= arr[i]) st.pop();
            ans[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return ans;
    }
}