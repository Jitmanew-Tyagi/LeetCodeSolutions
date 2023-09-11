class Solution {
    public int maxPower(String str) {
        if(str.length() == 1) {
            return 1;
        }
        int i=0, j=i+1;
        int maxLen = -1;
        while(j < str.length()) {
            char ch = str.charAt(i);
            if(str.charAt(j) != ch)
                i = j;
            j++;
            maxLen = Math.max(maxLen, j - i);
        }
        return maxLen;
    }
}