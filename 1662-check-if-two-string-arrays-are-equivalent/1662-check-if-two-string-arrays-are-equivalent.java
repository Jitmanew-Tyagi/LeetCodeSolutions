class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb = new StringBuilder();
        for(String s : word1) sb.append(s);
        for(String s : word2) sb.append(s);
        if(sb.length() % 2 != 0) return false;
        for(int i = 0; i < sb.length() / 2; i ++) {
            if(sb.charAt(i) != sb.charAt(i + (sb.length() / 2))) return false;
        }
        return true;
    }
}