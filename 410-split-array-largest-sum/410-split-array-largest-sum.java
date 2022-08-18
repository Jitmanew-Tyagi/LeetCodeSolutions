class Solution {
    public int splitArray(int[] weights, int days) {
        int s = max(weights), e = (int)1e9, ans = 1;
        while(s <= e) {
            int mid = s + (e - s) / 2;
            if(completable(weights, mid, days)) {
                ans = mid;
                e = mid - 1;
            } else s = mid + 1;
        }
        return ans;
    }
    
    public static boolean completable(int[] arr, int wt, int days) {
        int w = 0, nod = 1;
        for(int i : arr) {
            w += i;
            if(w > wt) {
                nod ++;
                w = i;
            }
        }
        return nod <= days;
    }
    
    public int max(int[] wts) {
        int max = wts[0];
        for(int i : wts) if(i > max) max = i;
        return max;
    }
}