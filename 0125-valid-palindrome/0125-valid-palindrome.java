class Solution {
    public boolean isPalindrome(String str) {
        
        str = str.toLowerCase();
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < str.length(); i ++) {
            char c = str.charAt(i);
            if(isAlphaNumeric(c) == true) sb.append(c);
        }
        str = sb.toString();
        int s = 0, e = str.length() - 1;
        while(s < e) {
            if(str.charAt(s) != str.charAt(e)) return false;
            s ++;
            e --;
        }
        return true;
    }
    
    public boolean isAlphaNumeric(char c) {
        if(c >= 'a' && c <= 'z') return true;
        if(c >= '0' && c <= '9') return true;
        return false;
    }
}