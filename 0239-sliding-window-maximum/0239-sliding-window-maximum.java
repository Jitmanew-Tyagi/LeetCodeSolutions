class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ngr = ngr(nums);
        int[] ans = new int[nums.length - k + 1];
        int i = 0, j = 0;
        while(i < ans.length) {
            if(j < i) j = i;
            while(ngr[j] < i + k) j = ngr[j];
            ans[i ++] = nums[j];
        }
        return ans;
    }
    
    public int[] ngr(int[] nums) {
        int n = nums.length, ans[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = n - 1; i >= 0; i --) {
            while(!st.isEmpty() && nums[st.peek()] <= nums[i]) st.pop();
            ans[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return ans;
    }
}