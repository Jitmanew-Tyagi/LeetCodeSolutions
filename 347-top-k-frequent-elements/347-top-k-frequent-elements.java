class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i : nums) {
            hm.put(i, hm.getOrDefault(i, 0) + 1);
        }
        List<List<Integer>> freq = new ArrayList<>();
        for(int i = 0; i < n + 1; i ++) freq.add(new ArrayList<>());
        for(int ele : hm.keySet()) freq.get(hm.get(ele)).add(ele);
        int idx = 0, ans[] = new int[k];
        for(int i = n; i >= 0; i --) {
            if(freq.get(i).size() > 0) {
                for(int x : freq.get(i)) {
                    if(idx == k) return ans;
                    ans[idx ++] = x;
                }
            }
        }
        return ans;
    }
}