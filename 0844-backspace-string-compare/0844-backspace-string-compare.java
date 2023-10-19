class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> st = new Stack<>();
        for(char c : s.toCharArray()) {
            if(c == '#') {
                if(!st.isEmpty()) st.pop();
            }
            else st.push(c);
        } 
        String a = st.toString();
        st = new Stack<>();
        for(char c : t.toCharArray()) {
            if(c == '#') {
                if(!st.isEmpty()) st.pop();
            }
            else st.push(c);
        } 
        return a.equals(st.toString());
    }
}