class Solution {
    public void reverseString(char[] s) {
        int si = 0, ei = s.length - 1;
        while(si < ei) {
            char temp = s[si];
            s[si ++] = s[ei];
            s[ei --] = temp;
        }
    }
}