class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length, si = 0, ei = n - 1, pl = -1;
        if(x < arr[0]) return getList(arr, 0, k - 1);
        if(x > arr[n - 1]) return getList(arr, n - k, n - 1);
        
        while(si <= ei) {
            int mid = si + (ei - si) / 2;
            if(arr[mid] < x) si = mid + 1;
            else {
                pl = mid;
                ei = mid - 1;
            }
        }
        si = Math.max(0, pl - k);
        ei = Math.min(n - 1, pl + k);
        
        while((ei - si + 1) > k) {
            if(Math.abs(arr[ei] - x) >= Math.abs(x - arr[si])) ei --;
            else si ++;
        }
        
        return getList(arr, si, ei);
    }   
    
    public List<Integer> getList(int[] arr, int si, int ei) {
        List<Integer> ans = new ArrayList<>();
        for(int i = si; i <= ei; i ++) {
            ans.add(arr[i]);
        }
        return ans;
    }
}