class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < n - 2; i ++) {
            int reqd = 0 - nums[i], lo = i + 1, hi = n - 1;
            if(i == 0 || nums[i] != nums[i - 1]) {
                while(lo < hi) {
                    int sum = nums[lo] + nums[hi];
                    if(sum == reqd) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[lo]);
                        temp.add(nums[hi]);
                        ans.add(temp);
                        while(lo < hi && nums[lo] == nums[lo + 1]) lo ++;
                        while(lo < hi && nums[hi] == nums[hi - 1]) hi --;
                        lo ++; hi --;
                    } else if(sum < reqd) lo ++;
                    else hi --;
                }
            }
        }
        return ans;
    }
}