class Solution {
    public int minimumOperations(int[] nums) {
        int n = nums.length, count = 0;
        Arrays.sort(nums);
        while(nums[n - 1] != 0) { //Pratyas sir OP
            count ++;
            int ele = nums[getFirst(nums)];
            for(int i = 0; i < n; i ++) {
                if(nums[i] != 0) {
                    nums[i] -= ele;
                }
            }
        }
        return count;
    }
    
    public int getFirst(int[] nums) {
        int s = 0, e = nums.length - 1, ans = -1;
        while(s <= e) {
            int mid = s + (e - s) / 2;
            if(nums[mid] == 0) s = mid + 1;
            else {
                ans = mid;
                e = mid - 1;
            }
        }
        return ans;
    }
}