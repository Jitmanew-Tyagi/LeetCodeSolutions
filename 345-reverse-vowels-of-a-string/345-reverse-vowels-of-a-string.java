class Solution {
    public String reverseVowels(String s) {
        char[] x = s.toCharArray();
        int i = 0, j = x.length - 1;
        while(i < j) {
            if(isVovel(x[i]) && isVovel(x[j])) {
                swap(x, i ++, j --);
            } else if(isVovel(x[i])) {
                j --;
            } else if(isVovel(x[j])) {
                i ++;
            } else {
                i ++;
                j --;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : x) sb.append(c);
        return sb.toString();
    }
    
    public boolean isVovel(char c) {
        return c=='a' || c=='A' || c=='e' || c=='E' || c=='i' || c=='I' || c=='o' || c=='O' || c=='u' || c=='U';
    }
    
    public void swap(char[] c, int i, int j) {
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
    }
}