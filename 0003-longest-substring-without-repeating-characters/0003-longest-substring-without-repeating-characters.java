class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> hs = new HashSet<>();
        int l = 0, r = 0, n = s.length(), ans = 0;
        while(r < n) {
            char c = s.charAt(r ++);
            while(hs.contains(c)) hs.remove(s.charAt(l ++));
            hs.add(c);
            ans = Math.max(ans, r - l);
        }
        return ans;
    }
}