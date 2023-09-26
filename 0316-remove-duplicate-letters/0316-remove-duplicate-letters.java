class Solution {
    public String removeDuplicateLetters(String s) {
        int[] fm = new int[26];
        for(char c : s.toCharArray()) fm[c - 'a'] ++;
        boolean[] taken = new boolean[26];
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()) {
            while(sb.length() > 0 && 
                  !taken[c - 'a'] && 
                  sb.charAt(sb.length() - 1) > c && 
                  fm[sb.charAt(sb.length() - 1) - 'a'] > 0) {
                taken[sb.charAt(sb.length() - 1) - 'a'] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
            
            if(!taken[c - 'a']) {
                sb.append(c);
                taken[c - 'a'] = true;
            }
            fm[c - 'a'] --;
        }
        return sb.toString();
    }
}