class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0, r = 0, len = 0, n = s.length();
        HashSet<Character> hs = new HashSet<>();
        while(r < n) {
            char c = s.charAt(r);
            while(hs.contains(c)) {
                hs.remove(s.charAt(l ++));
            }
            hs.add(c);
            r ++;
            len = Math.max(len, r - l);
        }
        return len;
    }
}