class Solution {
    public int longestConsecutive(int[] nums) {
        int maxLength = 0;
        Map<Integer, Boolean> hm = new HashMap<>();
        for(int ele : nums) hm.put(ele, true);
        for(int ele : nums) if(hm.containsKey(ele - 1)) hm.put(ele, false);
        for(int ele : hm.keySet()) {
            if(hm.get(ele)) {
                int tl = 1;
                while(hm.containsKey(ele + tl)) tl ++;
                maxLength = Math.max(maxLength, tl);
            }
        }
        return maxLength;
    }
}