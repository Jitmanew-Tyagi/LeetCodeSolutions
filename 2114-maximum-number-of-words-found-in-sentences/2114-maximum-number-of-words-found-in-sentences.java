class Solution {
    public int mostWordsFound(String[] sentences) {
        int max = 0;
        for(String sentence : sentences) {
            int now = getNoOfWords(sentence);
            if(now > max) max = now;
        }
        return max;
    }
    
    public int getNoOfWords(String sentence) {
        int count = 1; 
        for(int i = 0; i < sentence.length(); i ++) {
            if(sentence.charAt(i) == ' ') count ++;
        }
        return count;
    }
}