class Solution {
    public boolean wordPattern(String pattern, String s) {
        StringBuilder sb1 = new StringBuilder(), sb2 = new StringBuilder();
        int i = 0;
        Map<Character, Integer> hm1 = new HashMap<>();
        Map<String, Integer> hm2 = new HashMap<>();
        for(char c : pattern.toCharArray()) {
            if(!hm1.containsKey(c)) hm1.put(c, i ++);
            sb1.append(hm1.get(c));
        }
        i = 0;
        for(String c : s.split(" ")) {
            if(!hm2.containsKey(c)) hm2.put(c, i ++);
            sb2.append(hm2.get(c));
        }
        return sb1.toString().equals(sb2.toString());
    }
}