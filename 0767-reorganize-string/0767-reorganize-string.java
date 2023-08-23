class Solution {
    public String reorganizeString(String s) {
        int[] fm = new int[26];
        for(char c : s.toCharArray()) fm[c -'a'] += 1;
        int max = 0, idx = 0;
        for(int i = 0; i < 26; i ++) {
            if(fm[i] > fm[max]) max = i;
        }
        if(fm[max] > (s.length() + 1) / 2) return "";
        char[] ans = new char[s.length()];
        while(--fm[max] >= 0) {
            ans[idx] = (char)(max + 'a');
            idx += 2;
        }
        for(int i = 0; i < 26; i ++) {
            if(fm[i] == 0) continue;
            while(-- fm[i] >= 0){
                if(idx >= ans.length) idx = 1;
                ans[idx] = (char)('a' + i);
                idx += 2;
            }
        }
        return String.valueOf(ans);
    }
}