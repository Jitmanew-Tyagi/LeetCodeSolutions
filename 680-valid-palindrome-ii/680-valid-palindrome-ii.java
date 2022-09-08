class Solution {
    public boolean validPalindrome(String s) {
        int i = 0, j = s.length() - 1, count = 0;
        while(i < j) {
            if(s.charAt(i) == s.charAt(j)) {
                i ++;
                j --;
            } else if(count == 1) return false;
            else {
                return isPal(s, i + 1, j) || isPal(s, i, j - 1);
            }
        }
        return true;
    }
    public boolean isPal(String s, int i, int j) {
        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) return false;
            else {
                i ++;
                j --;
            }
        }
        return true;
    }
}