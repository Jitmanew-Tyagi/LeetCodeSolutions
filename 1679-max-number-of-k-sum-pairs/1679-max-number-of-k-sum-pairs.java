class Solution {
    public int maxOperations(int[] arr, int target) {
        int n = arr.length;
        Map<Integer, Integer> hm = new HashMap<>();
        for(int ele : arr) hm.put(ele, hm.getOrDefault(ele, 0) + 1);
        int ans = 0;
        for(int ele : hm.keySet()) {
            int compl = target - ele;
            if(compl == ele) {
                ans += hm.get(ele) / 2;
                hm.put(ele, 0);
            }
            else if(hm.containsKey(compl)) {
                ans += Math.min(hm.get(ele), hm.get(compl));
                hm.put(ele, 0);
                hm.put(compl, 0);
            }
        }
        return ans;
    }
}