class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        for(String word : s.split(" ")) sb.append(new StringBuilder(word).reverse()).append(" ");
        return sb.delete(sb.length() - 1, sb.length()).toString();
    }
}