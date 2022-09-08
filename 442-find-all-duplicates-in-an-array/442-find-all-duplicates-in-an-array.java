class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int i = 0;
        while(i < nums.length) {
            if(nums[nums[i] - 1] == nums[i]) i ++;
            else {
                int x = nums[i];
                nums[i] = nums[x - 1];
                nums[x - 1] = x;
            }
        }
        for(i = 0; i < nums.length; i ++) {
            if(nums[i] != i + 1) ans.add(nums[i]);
        }
        return ans;
    }
}