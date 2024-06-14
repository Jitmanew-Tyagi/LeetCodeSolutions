class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n; i ++) {
            if(s.charAt(i) == '(') st.push(i);
            else {
                if(!st.isEmpty() && s.charAt(st.peek()) == '(') st.pop();
                else st.push(i);
            }
        }
        int ans = 0, prev = -1;
        if(st.isEmpty()) return n;
        for(int ele : st) {
            int len = ele - prev - 1;
            ans = Math.max(ans, len);
            prev = ele;
        }
        return Math.max(ans, n - prev - 1);
    }
}