class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length, ngr[] = ngr(nums);
        int[] ans = new int[n - k + 1];
        int ng = 0;
        for(int i = 0; i <= n - k; i ++) {
            if(ng < i) ng = i;
            while(ngr[ng] < i + k) ng = ngr[ng];
            ans[i] = nums[ng];
        }
        return ans;
    }
    
    public int[] ngr(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int n = arr.length, ans[] = new int[n];
        for(int i = n - 1; i >= 0; i --) {
            while(!st.isEmpty() && arr[st.peek()] <= arr[i]) st.pop();
            ans[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return ans;
    }
}