class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> hs = new HashSet<>();
        int l = 0, r = 0, ans = 0;
        while(r < s.length()) {
            while(hs.contains(s.charAt(r))) hs.remove(s.charAt(l ++));
            hs.add(s.charAt(r ++));
            ans = Math.max(ans, r - l);
        }
        return ans;
    }
}