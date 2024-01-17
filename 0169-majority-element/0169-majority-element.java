class Solution {
    public int majorityElement(int[] nums) {
        int maj = -1, votes = 1;
        for(int ele : nums) {
            if(ele == maj) votes ++;
            else  {
                votes --;
                if(votes == 0) {
                    maj = ele;
                    votes = 1;
                }
            }
        }
        return maj;
    }
}