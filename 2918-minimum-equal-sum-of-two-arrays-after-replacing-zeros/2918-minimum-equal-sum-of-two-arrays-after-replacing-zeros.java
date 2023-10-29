class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long sum1 = sum(nums1), sum2 = sum(nums2);
        int z1 = noz(nums1), z2 = noz(nums2);
        if(z1 == z2 && z1 == 0) return sum1 == sum2 ? sum1 : -1;
        if(z1 == 0) {
            if(sum2 + z2 <= sum1) return sum1 + z1;
        } else if(z2 == 0) {
            if(sum1 + z1 <= sum2) return sum2 + z2;
        } else {
            return Math.max(sum1 + z1, sum2 + z2);
        }
        return -1;
    }
    
    public long sum(int[] nums) {
        long ans = 0;
        for(int i : nums) ans += i;
        return ans;
    }
    
    public int noz(int[] nums) {
        int noz = 0;
        for(int i : nums) if(i == 0) noz ++;
        return noz;
    }
}