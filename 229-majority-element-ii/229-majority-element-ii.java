class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int m1 = -1, m2 = -1, c1 = 0, c2 = 0;
        for(int i : nums) {
            if(i == m1) c1 ++;
            else if (i == m2) c2 ++;
            else {
                if(c1 == 0) {
                    m1 = i;
                    c1 = 1;
                } else if(c2 == 0) {
                    m2 = i; 
                    c2 = 1;
                }
                else {
                    c1 --; c2 --;
                }
            }
        }
        c1 = 0; c2 = 0;
        for(int x : nums) {
            if(x == m1) c1 ++;
            else if(x == m2) c2 ++;
        }
        List<Integer> ans = new ArrayList<>();
        if(c1 > nums.length / 3) ans.add(m1);
        if(c2 > nums.length / 3) ans.add(m2);
        return ans;
    }
}