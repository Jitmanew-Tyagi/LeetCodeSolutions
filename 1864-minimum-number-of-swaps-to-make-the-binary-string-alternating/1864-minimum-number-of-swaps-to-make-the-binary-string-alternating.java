class Solution {
    public int minSwaps(String s) {
        int noz = 0, noo = 0, n = s.length(), ans = 0;
        for(char c : s.toCharArray()) {
            if(c == '0') noz ++;
            else noo ++;
        }
        if(Math.abs(noo - noz) > 1) return -1;
        if(noo == noz) return Math.min(helper(s, '0'), helper(s, '1'));
        return noo > noz ? helper(s, '1') : helper(s, '0');
    }
    
    public int helper(String s, char c) {
        int swaps = 0;
        for(char ch : s.toCharArray()) {
            swaps += ch != c ? 1 : 0;
            c ^= 1;
        }
        return swaps / 2;
    }
}