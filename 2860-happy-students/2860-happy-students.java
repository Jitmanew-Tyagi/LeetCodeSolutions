class Solution {
    public int countWays(List<Integer> nums) {
        Collections.sort(nums);
        int ans = nums.get(0) == 0 ? 0 : 1;
        for(int i = 0; i < nums.size(); i ++) {
            if(i == nums.size() - 1 && nums.get(i) < i + 1) ans ++;
            else if(nums.get(i) < i + 1 && nums.get(i + 1) > i + 1) ans ++;
        }
        return ans;
    }
}