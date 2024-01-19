class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length, z = 0, m = 0, t = n - 1;
        while(m <= t) {
            if(nums[m] == 0) swap(nums, z ++, m ++);
            else if(nums[m] == 1) m ++;
            else swap(nums, m, t --);
        }
    }
    
    public static void swap(int[] arr,int i,int j) { // VARUN SIR OP
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}