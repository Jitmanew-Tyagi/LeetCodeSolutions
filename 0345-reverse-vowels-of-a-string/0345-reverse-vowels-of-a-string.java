class Solution {
    public String reverseVowels(String s) {
        char[] str = s.toCharArray();  
        int i = 0, j = str.length - 1;
        while(i < j) {
            while(i < j && isVowel(str[i]) == false) i ++;
            while(i < j && isVowel(str[j]) == false) j --;
            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;
            i ++;
            j --;
        }
        
        String ans = "";
        for(char c : str) ans += c;
        return ans;
    }
    
    public static boolean isVowel(char c){
        c = Character.toLowerCase(c);
        return c == 'a' ||c == 'e' ||c == 'i' ||c == 'o' ||c == 'u';
           
    }
}