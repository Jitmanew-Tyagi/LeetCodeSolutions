class Solution {
    String[] arr = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        return digits.length() == 0 ? new ArrayList<String>() : helper(digits);
    }
    
    public List<String> helper(String dig) {
        if(dig.length() == 0) {
            List<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        //base
        List<String> faith = helper(dig.substring(1));
        List<String> ans = new ArrayList<>();
        int currDig = dig.charAt(0) - '0';
        String lettersOnDigit = this.arr[currDig];
        for(char c : lettersOnDigit.toCharArray()) {
            for(String str : faith) {
                ans.add(c + str);
            }
        }
        return ans;
    }
    
    
}