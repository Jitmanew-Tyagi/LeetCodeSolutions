class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        reverse(nums, 0, n - k - 1); //reversing part a
        reverse(nums, n - k, n - 1); // reversing part b
        reverse(nums, 0, n - 1);
    }
    
    public void reverse(int[] arr, int i, int j) {
        while(i <= j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i ++; j --;
        }
    }
}