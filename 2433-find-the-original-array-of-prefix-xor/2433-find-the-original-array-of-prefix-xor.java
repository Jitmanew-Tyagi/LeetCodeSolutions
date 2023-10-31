class Solution {
    public int[] findArray(int[] pref) {
        int n = pref.length, prev = pref[0], ans[] = new int[n], idx = 1;
        ans[0] = pref[0];
        for(int i = 1; i < n; i ++){
            int ele = 0;
            for(int j = 0; j < 32; j ++) {
                boolean a = checkIfOn(prev, j), b = checkIfOn(pref[i], j);
                if((a & !b) || (!a & b)) ele = turnOn(ele, j);
            }
            ans[idx ++] = ele;
            prev = pref[idx - 1];
        }
        return ans;
    }
    
    public boolean checkIfOn(int ele, int x) {
        return (ele & (1 << x)) > 0;
    }
    
    public int turnOn(int ele, int x) {
        ele = ele | (1 << x);
        return ele;
    }
}