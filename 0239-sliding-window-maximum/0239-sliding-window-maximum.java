class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int j = 0, n = nums.length;
        int[] ngr = ngr(nums);
        int[] ans = new int[n - k + 1];
        
        for(int i = 0; i <= n - k; i ++) {
            if(j < i) j = i;
            while(ngr[j] < i + k) j = ngr[j];
            ans[i] = nums[j];
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