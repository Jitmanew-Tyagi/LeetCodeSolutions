class Solution {
    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();
        for(String s : path.split("/")) {
            if(s.length() == 0 || s.equals(".")) continue;
            if(s.equals("..")) {
                if(!st.isEmpty()) st.pop();
            } else st.push(s);            
        }
        if(st.isEmpty()) return "/";
        StringBuilder sb = new StringBuilder();
        for(String s : st) sb.append("/").append(s);
        return sb.toString();
    }
}