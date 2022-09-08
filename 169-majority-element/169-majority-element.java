class Solution {
    public int majorityElement(int[] nums) {
        int maj = -1, count = 1;
        for(int i : nums) {
            if(i == maj) {
                count ++;
            } else {
                count --;
                if(count == 0) {
                    maj = i;
                    count ++;
                }
            }
        }
        return maj;
    }
}