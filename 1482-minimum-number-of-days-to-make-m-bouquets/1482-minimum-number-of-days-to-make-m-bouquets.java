class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int s = min(bloomDay), e = (int)1e9, ans = -1;
        while(s <= e) {
            int mid = s + (e - s) / 2;
            if(completable(bloomDay, mid, m, k)) {
                ans = mid;
                e = mid - 1;
            } else s = mid + 1;
        }
        return ans;
    }
    
    public static boolean completable(int[] arr, int nod, int nob, int nof) {
       int k = 0, m = 0;
       for(int i : arr) {
           if(i <= nod) {
               k ++;
               if(k == nof) {
                   m++;
                   k = 0;
                      
               }
           } else k = 0;
       }
        return m >= nob;
    }
    
    public int min(int[] wts) {
        int min = wts[0];
        for(int i : wts) if(i < min) min = i;
        return min;
    }
}