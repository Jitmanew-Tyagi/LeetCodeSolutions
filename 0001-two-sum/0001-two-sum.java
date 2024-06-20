class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i < nums.length; i ++) hm.put(nums[i], i);
        for(int i = 0; i < nums.length; i ++) {
            int rem = target - nums[i];
            if(hm.containsKey(rem) && hm.get(rem) != i) 
                return new int[] {i, hm.get(rem)};
        }
        return new int[] {0, 0};
    }
}