class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> hm = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()) hm.put(c, hm.getOrDefault(c, 0) + 1);
        int n = s.length();
        ArrayList<Character>[] arl = new ArrayList[n + 1];
        for(char c : hm.keySet()) {
            int freq = hm.get(c);
            if(arl[freq] == null) arl[freq] = new ArrayList<Character>();
            arl[freq].add(c);
        }
        for(int i = n; i >= 0; i --) {
            if(arl[i] != null) {
                for(char ch : arl[i]) {
                    for(int j = 0; j < i; j ++) sb.append(ch);
                }
            }
        }
        return sb.toString();
    }
}