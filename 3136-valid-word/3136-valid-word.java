class Solution {
    public boolean isValid(String word) {
        if(word.length() < 3) return false;
        boolean v = false, c = false;
        int noc = 0;
        for(char ch : word.toCharArray()) {
            ch = Character.toLowerCase(ch);
            if((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                if(isVovel(ch)) v = true;
                else c = true;
                noc ++;
            }
            else if(ch >= '0' && ch <= '9') noc ++;
            else {
                return false;
            }
        }
        return c && v && (noc >= 3);
    }
    
    public boolean isVovel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'; 
    }
}