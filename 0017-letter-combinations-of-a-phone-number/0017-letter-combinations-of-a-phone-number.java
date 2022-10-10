class Solution {
    public List<String> letterCombinations(String digits) {
        return digits.length() == 0 ? new ArrayList<>() : helper(digits);
    }
    
    String[] arr = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
    public List<String> helper(String str) {
        if(str.length() == 0) {
            List<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        
        List<String> faith = helper(str.substring(1));
        List<String> ans = new ArrayList<>();
        int currDigit = str.charAt(0) - '0';
        String chars = arr[currDigit];
        for(char c : chars.toCharArray()) {
            for(String s : faith) {
                ans.add(c + s);
            }
        }
        return ans;
    }
}