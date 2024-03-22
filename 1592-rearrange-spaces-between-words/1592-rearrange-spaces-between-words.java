class Solution {
    public String reorderSpaces(String text) {
        StringBuilder ans = new StringBuilder();
        int sp = 0, words = 0;
        for(char c : text.toCharArray()) if(c == ' ') sp ++;
        for(String word : text.split(" ")) if(word.length() > 0) words ++;
        int nosp = words == 1 ? 0 : sp / (words - 1);
        for(String word : text.split(" ")) {
            if(word.length() > 0) {
                ans.append(word);
                for(int not = 0; not < nosp; not ++) ans.append(" ");
            }
        }
        ans.delete(ans.length() - nosp, ans.length());
        while(ans.length() < text.length()) ans.append(" ");
        return ans.toString();
    }
}