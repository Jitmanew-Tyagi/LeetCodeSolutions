class Solution {
    public int bestClosingTime(String customers) {
        int n = customers.length(), ysf = 0, nsf = 0;
        Map<Integer, int[]> hm = new HashMap<>();
        for(int i = 0; i < n; i ++) {
            hm.put(i, new int[]{ysf, nsf});
            if(customers.charAt(i) == 'Y') ysf ++;
            else nsf ++;
            
        }
        
        int ans = 0, minPen = n + 1;
        for(int i = 0; i < n; i ++) {
            int pen = hm.get(i)[1] + ysf - (hm.get(i)[0]);
            if(pen < minPen) {
                minPen = pen;
                ans = i;
            }
        }
        if(nsf < minPen) return n;
        return ans;
    }
}