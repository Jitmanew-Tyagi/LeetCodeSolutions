class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> hs = new HashSet<>();
        for(String str : wordDict) hs.add(str);
        rec(s, 0, 0, hs, "");
        for(int i = 0; i < ans.size(); i ++) ans.set(i, ans.get(i).substring(1));
        return ans;
    }
    
    List<String> ans = new ArrayList<>();
    public boolean rec(String s, int si, int ei, HashSet<String> hs, String curr) {
        if(ei == s.length()) {
            boolean isMade = si == s.length();
            if(isMade) ans.add(curr);;
            return isMade;
        }
        boolean ans1 = false, ans2 = false;
        if(hs.contains(s.substring(si, ei + 1))) ans1 = rec(s, ei + 1, ei + 1, hs, curr + " " + s.substring(si, ei + 1));
        ans2 = rec(s, si, ei + 1, hs, curr);
        return ans1 || ans2;
    }
}