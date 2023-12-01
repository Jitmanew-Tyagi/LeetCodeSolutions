class Solution {
    public String removeTrailingZeros(String num) {
        int x = num.length() - 1;
        while(x >= 0) {
            if(num.charAt(x) == '0') x --;
            else break;
        }
        return num.substring(0, x + 1);
    }
}