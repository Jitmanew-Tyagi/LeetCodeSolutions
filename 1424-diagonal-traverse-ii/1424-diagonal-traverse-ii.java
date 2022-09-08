class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int len = 0, idxx = 0, ans[];
        HashMap<Integer, LinkedList<Integer>> hm = new HashMap<>();
        for(int i = 0; i < nums.size(); i ++) {
            for(int j = 0; j < nums.get(i).size(); j ++) {
                int idx = i + j;
                hm.putIfAbsent(idx, new LinkedList<>());
                hm.get(idx).addFirst(nums.get(i).get(j));
                len ++;
            }
        }
        int prev = -1;
        ans = new int[len];
        for(int i = 0; i < hm.keySet().size(); i ++) {
            LinkedList<Integer> x = hm.get(i);
            while(x.size() > 0) ans[idxx ++] = x.removeFirst();
        }
        return ans;   
    }
}