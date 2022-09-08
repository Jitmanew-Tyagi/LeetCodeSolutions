class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int i = 0, j = 0, n = nums.length;
        while(j < n) {
            if(nums[j] % 2 == 0) swap(nums, i ++, j ++);
            else j ++;
        }
        return nums;
    }
    
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}