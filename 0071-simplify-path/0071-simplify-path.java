class Solution {
    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();
        for(String str : path.split("/")) {
            if(str.equals("..")) {
                if(!st.isEmpty()) st.pop();
            }
            else if(str.length() > 0 && !str.equals(".")) st.push(str);
        }
        if(st.isEmpty()) return "/";
        StringBuilder sb = new StringBuilder();
        for(String s : st) sb.append("/").append(s);
        return sb.toString();
    }
}