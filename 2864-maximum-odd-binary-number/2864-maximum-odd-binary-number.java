class Solution {
    public String maximumOddBinaryNumber(String s) {
        int obc = bitCount(s);
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < s.length(); i ++){
            if(obc > 1) {
                sb.append("1");
                obc --;
            }
            else sb.append("0");
        }
        sb.append("1");
        return sb.toString();
    }
    
    public int bitCount(String s) {
        int count = 0;
        for(char c : s.toCharArray()) if(c == '1') count ++;
        return count;
    }
}