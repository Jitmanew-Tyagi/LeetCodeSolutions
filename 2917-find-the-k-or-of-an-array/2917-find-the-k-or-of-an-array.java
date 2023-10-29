class Solution {
    public int findKOr(int[] nums, int k) {
        int kor = 0;
        for(int i = 0; i < 32; i ++) { //checking for all 32 bits
            int count = 0;
            for(int ele : nums) { // checking every element
                if(checkIfOn(ele, i)) count ++; // if the bit is on. increase the count
            }
            if(count >= k) kor = (kor | (1 << i)); // if number of elements >= k, switch the bit ON
        }
        return kor;
    }
    
    public boolean checkIfOn(int num, int k) {
        return (num & (1 << k)) > 0;
    }
}