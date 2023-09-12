class Solution {
    public boolean isLongPressedName(String name, String typed) {
        if(typed.length() < name.length()) return false;
        int i = 0, j = 0;
        while(i < name.length()) {
            if(j == typed.length()) return false;
            if(name.charAt(i) == typed.charAt(j)) {
                i ++;
                j ++;
            } else {
                if(j == 0 || typed.charAt(j) != typed.charAt(j - 1)) 
                    return false; 
                else j ++;
            }
        }
        while(j != typed.length()) {
            if(typed.charAt(j) != typed.charAt(j - 1)) return false;
            j ++;
        }
        return true;
    }
}