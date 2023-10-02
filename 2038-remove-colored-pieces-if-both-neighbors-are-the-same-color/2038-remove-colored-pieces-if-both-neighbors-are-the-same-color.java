class Solution {
    public boolean winnerOfGame(String colors) {
        int scoreA = 0, scoreB = 0, j = 0;
        while(j < colors.length()) {
            int count = 0;
            while(j < colors.length() && colors.charAt(j) == 'A') {
                count ++;
                j ++;
            }
            scoreA += count >= 3 ? count - 2 : 0;
            count = 0;
            while(j < colors.length() && colors.charAt(j) == 'B') {
                j ++;
                count ++;
            }
            scoreB += count >= 3 ? count - 2 : 0;
        }
        return scoreA > scoreB; 
    }
}