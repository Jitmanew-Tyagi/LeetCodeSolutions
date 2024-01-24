class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        for(int i = nums.length - 1; i >= 0; i --) {
            int ele = nums[i];
            while(! st.isEmpty() && st.peek() <= ele) st.pop();
            st.push(ele);
        }
        
        int[] ans = new int[nums.length];
        for(int i = nums.length - 1; i >= 0; i --) {
            while(!st.isEmpty() && st.peek() <= nums[i]) st.pop();
            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(nums[i]);
        }
        return ans;
    }
}