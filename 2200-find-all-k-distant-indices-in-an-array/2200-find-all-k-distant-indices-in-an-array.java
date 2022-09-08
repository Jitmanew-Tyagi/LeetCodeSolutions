class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> jvals = new ArrayList<>();
        for(int j = 0; j < nums.length; j ++) if(nums[j] == key) jvals.add(j);
        HashSet<Integer> ans = new HashSet<>();
        for(int j : jvals) {
            for(int i = 0; i < nums.length; i ++) {
                if(Math.abs(i - j) <= k) ans.add(i);
            }
        }
        List<Integer> sortedAns = new ArrayList<>(ans);
        Collections.sort(sortedAns);
        return sortedAns;
        
    }
}