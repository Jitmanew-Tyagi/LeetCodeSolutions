class Solution {
    public int maxPower(String s) {
        int i = 0, maxLength = 0;
        while(i < s.length()) {
            int j = i + 1;
            while(j < s.length() && s.charAt(j) == s.charAt(i)) 
                j ++;
            maxLength = Math.max(maxLength, j - i);
            i = j;
        }
        return maxLength;
    }
}