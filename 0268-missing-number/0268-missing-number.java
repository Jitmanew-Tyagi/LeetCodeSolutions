class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        return ((n * (n + 1)) / 2) - Arrays.stream(nums).parallel().reduce(0, (x1, x2) -> x1 + x2);
    }
}