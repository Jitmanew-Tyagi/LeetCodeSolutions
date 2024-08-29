class Solution {
    public int mostWordsFound(String[] sentences) {
        int maxNoOfWords = 0;
        for(String s : sentences) {
            int now = getNoOfWords(s);
            if(now > maxNoOfWords) maxNoOfWords = now;
        }
        return maxNoOfWords;
    }
    
    public int getNoOfWords(String s) {
        int nos = 0;
        for(int i = 0; i < s.length(); i ++) {
            if(s.charAt(i) == ' ') nos ++;
        }
        return nos + 1;
    }
    
}