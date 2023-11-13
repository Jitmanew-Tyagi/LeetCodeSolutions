class Solution {
    public String sortVowels(String s) {
        List<Character> c = new ArrayList<>(), v = new ArrayList<>();
        for(char ch : s.toCharArray()) {
            if(isVovel(ch)) v.add(ch);
            else c.add(ch);
        }
        Collections.sort(v);
        StringBuilder sb = new StringBuilder();
        int vi = 0, ci = 0, idx = 0;
        while(idx < s.length()) {
            if(isVovel(s.charAt(idx ++))) sb.append(v.get(vi ++));
            else sb.append(c.get(ci ++));
        }
        return sb.toString();
    }
    
    public boolean isVovel(char c) {
        return c == 'a' ||
            c == 'e' ||
            c == 'i' ||
            c == 'o' ||
            c == 'u' || 
            c == 'A' ||
            c == 'E' ||
            c == 'I' ||
            c == 'O' ||
            c == 'U';
    }
}