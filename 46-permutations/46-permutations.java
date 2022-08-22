class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> ques = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for(int i : nums) ques.add(i);
        List<List<Integer>> ans = new ArrayList<>();
        permHelper(ques, temp, ans);
        return ans;
    }
    
    public void permHelper(List<Integer> nums, List<Integer> ans, List<List<Integer>> fans) {
       if(nums.size() == 0) {
           fans.add(new ArrayList<Integer>(ans));
           return;
       }
       for(int i = 0; i < nums.size(); i ++) {
           int x = nums.remove(i);
           ans.add(x);
           permHelper(nums, ans, fans);
           ans.remove(ans.size() - 1);
           nums.add(i, x);
       } 
    }
    
}