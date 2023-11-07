class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        float[] time = new float[n];
        
        for(int i = 0; i < n; i ++) {
            time[i] = (float)(dist[i] / (speed[i] * 1.0));
        }
        
        Arrays.sort(time);
        for(int i = 1; i < n; i ++) {
            if(time[i] - i <= 0) return i;
        }
        return n;
    }
}