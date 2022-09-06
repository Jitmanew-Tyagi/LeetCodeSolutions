class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;
        int n = s.length();
        HashMap<Character, Character> hm = new HashMap<>();
        for(int i = 0; i < n; i ++) {
            char a = s.charAt(i);
            char b = t.charAt(i);
            if(hm.containsKey(a)) {
                if(b != hm.get(a)) return false;
            } else {
                if(hm.containsValue(b)) return false;
                hm.put(a, b);
            }
        }
        return true;
    }
}