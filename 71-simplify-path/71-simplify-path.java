class Solution {
    public String simplifyPath(String path) {
        String[] arr = path.split("/");
        ArrayList<String> st = new ArrayList<>();
        for(String s : arr) {
            if(s.length() == 0 || s.equals(".")) continue;
            if(s.equals("..")) {
                if(!st.isEmpty())
                st.remove(st.size() - 1);
            }
            else st.add(s);
        }
        if(st.isEmpty()) return "/";
        StringBuilder sb =  new StringBuilder("/");
        for(int i = 0; i < st.size(); i ++) {
            if(i == st.size() - 1) {
                sb.append(st.get(i));
                return sb.toString();
            }
            sb.append(st.get(i) + "/");
        }
        return sb.toString();
    }
}