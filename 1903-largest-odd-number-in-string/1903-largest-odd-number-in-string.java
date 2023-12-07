class Solution {
    public String largestOddNumber(String num) {
        int idx = -1;
        for(int i = num.length() - 1; i >= 0; i --) {
            int x = num.charAt(i) - '0';
            if(x % 2 != 0) {
                idx = i;
                break;
            }
        }
        return num.substring(0, idx + 1);
    }
}