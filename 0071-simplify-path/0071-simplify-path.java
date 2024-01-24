class Solution {
    public String simplifyPath(String path) {
        String[] arr = path.split("/");
        Stack<String> st = new Stack<>();
        for(String s : arr) {
            if(s.length() == 0 || s.equals(".")) continue;
            else if(s.equals("..")) {
                if(!st.isEmpty()) st.pop();
            } else st.push(s);
        }
        if(st.isEmpty()) return "/";
        String ans = "";
        for(String dir : st) ans += "/" + dir;
        return ans;
    }
}