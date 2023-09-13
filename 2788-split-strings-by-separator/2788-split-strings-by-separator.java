class Solution {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> ans = new ArrayList<>();
        for(String word : words) {
            for(String w : word.split("\\"+separator)) {
                if(!w.isEmpty()) ans.add(w);
            }
        }
        return ans;
    }
}