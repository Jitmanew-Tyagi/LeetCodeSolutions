class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> hm = new HashMap<>();
        int l = 0, r = 0, ans = 0;
        while(r < s.length()) {
           // if(hm.getOrDefault(s.charAt(r), -1) >= l)
            if(hm.containsKey(s.charAt(r))) {
                int idx = hm.get(s.charAt(r));
                if(idx >= l) l = idx + 1;
            }
            hm.put(s.charAt(r), r ++);
            ans = Math.max(ans, r - l);
        }
        return ans;
    }
}