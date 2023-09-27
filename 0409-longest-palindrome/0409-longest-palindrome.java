class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for(int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            if(!hm.containsKey(c)) hm.put(c, 1);
            else {
                int oldFreq = hm.get(c);
                hm.put(c, oldFreq + 1);
            }
        }
        int len = 0;
        boolean odd = false;
        for(char c : hm.keySet()) {
            int freq = hm.get(c);
            len += freq % 2 == 0 ? freq : freq - 1;
            if(freq % 2 != 0) odd = true;
        }
        return odd ? len + 1 : len;
    }
}