class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            if(c == '(' ) st.push(i);
            else {
                if(!st.isEmpty() && s.charAt(st.peek()) == '(') st.pop();
                else st.push(i);
            }
        }
        
        int ans = 0, prev = -1;
        if(st.isEmpty()) return s.length();
        for(int ele : st) {
            int len = ele - prev - 1;
            if(len > ans) ans = len;
            prev = ele;
        }
        return Math.max(ans, s.length() - prev - 1);
    }
}