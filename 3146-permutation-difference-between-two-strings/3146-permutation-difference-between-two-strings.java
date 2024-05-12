class Solution {
    public int findPermutationDifference(String s, String t) {
        int ans = 0;
        Map<Character, Integer> hm = new HashMap<>();
        for(int i = 0; i < s.length(); i ++) hm.put(s.charAt(i), i);
        for(int i = 0; i < t.length(); i ++) ans += Math.abs(i - hm.get(t.charAt(i)));
        return ans;
    }
}