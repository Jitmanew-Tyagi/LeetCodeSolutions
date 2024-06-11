class Solution {
    public String reverseWords(String s) {
        Stack<String> st = new Stack<>();
        for(String p : s.split(" ")) if(p.length() > 0) st.push(p);
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()) sb.append(st.pop()).append(" ");
        return sb.toString().trim();
    }
}