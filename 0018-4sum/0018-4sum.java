class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < nums.length - 3; i ++){
            if(i != 0 && nums[i] == nums[i - 1]) continue;
            long ttbs = target;
            ttbs -= nums[i];
            List<List<Integer>> tempAns = threeSum(nums, ttbs , i);
            for(int x = 0; x < tempAns.size(); x ++) {
                tempAns.get(x).add(0, nums[i]);
                ans.add(tempAns.get(x));
            }
        }
        return ans;
    }
    
    public List<List<Integer>> threeSum(int[] nums, long target, int idx) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        for(int i = idx + 1; i < n - 2; i ++){
            twoSum(nums, i + 1, n - 1, target - nums[i], ans);
            while(i < n - 2 && nums[i] == nums[i + 1]) i ++;
        }
        return ans;
    }
    
    public void twoSum(int[] nums, int l, int r, long target, List<List<Integer>> ans) {
        int first = l - 1, left = l, right = r;
        while(left < right) {
            long sum = nums[left] + nums [right];
            if (sum < target) left ++;
            else if (nums[left] + nums[right] > target) right --;
            else {
                List<Integer> temp = new ArrayList<>();
                temp.add(nums[first]);
                temp.add(nums[left]);
                temp.add(nums[right]);
                ans.add(temp);
                while(left+1 < nums.length - 1 && nums[left] == nums[left + 1]) left ++;
                left++;
            }
        }
    }
}