class Solution {
    public int findKOr(int[] nums, int k) {
        int kor = 0;
        for(int i = 0; i < 32; i ++) {
            int count = 0;
            for(int ele : nums) {
                if(checkIfOn(ele, i)) count ++;
            }
            if(count >= k) kor = (kor | (1 << i));
        }
        return kor;
    }
    
    public boolean checkIfOn(int num, int k) {
        int mask = 1 << k;
        return (num & mask) > 0;
    }
}