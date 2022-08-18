class Solution {
    public int minSetSize(int[] arr) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int idx = 0;
        for(int i : arr) hm.put(i, hm.getOrDefault(i, 0) + 1);
        int[] prr = new int[hm.size()];
        for(int i : hm.keySet()) prr[idx ++] = hm.get(i);
        Arrays.sort(prr);
        int count = arr.length / 2, setSize = 0;
        for(int i = prr.length - 1; i >= 0; i --) {
            count -= prr[i];
            setSize ++;
            if(count <= 0) return setSize;
        }
        return setSize;
    }
}