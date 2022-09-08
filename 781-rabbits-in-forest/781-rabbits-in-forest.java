class Solution {
    public int numRabbits(int[] answers) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i : answers) hm.put(i, hm.getOrDefault(i, 0) + 1);
        int ans = 0;
        for(int i : hm.keySet()){
            ans += (i + 1) * Math.ceil(hm.get(i) / (i + 1.0));
        }
        return ans;
    }
}