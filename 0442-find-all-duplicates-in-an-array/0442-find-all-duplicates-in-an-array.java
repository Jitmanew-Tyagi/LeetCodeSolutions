class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length, freq[] = new int[n + 1];
        for(int i = 0; i < n; i ++) {
            int ele = nums[i];
            freq[ele] ++;
        }
        List<Integer> lst = new ArrayList<>();
        for(int i = 1; i <= n; i ++) {
            if(freq[i] == 2) lst.add(i);
        }
        return lst;
    }
}