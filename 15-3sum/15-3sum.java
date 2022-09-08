class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> ans = new LinkedList<>();
        for(int a = 0; a < n - 2; a ++) {
            int sum = -nums[a], lo = a + 1, hi = n - 1;
            if(a == 0 || (a > 0 && nums[a] != nums[a - 1])) {
                while(lo < hi) {
                    if(nums[lo] + nums[hi] == sum) {
                        ans.add(Arrays.asList(nums[a], nums[lo], nums[hi]));
                        while(lo < hi && nums[lo] == nums[lo + 1]) lo ++;
                        while(hi > lo && nums[hi] == nums[hi - 1]) hi --;
                        lo ++; hi --;
                    } else if(nums[lo] + nums[hi] < sum) lo ++;
                    else hi --;
                }
            }   
        }
        return ans;
    }
}